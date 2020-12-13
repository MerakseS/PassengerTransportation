package by.bsuir.poit.service.impl;

import by.bsuir.poit.dao.DaoProvider;
import by.bsuir.poit.dao.UserRepository;
import by.bsuir.poit.entity.Role;
import by.bsuir.poit.entity.User;
import by.bsuir.poit.service.ServiceException;
import by.bsuir.poit.service.UserService;
import org.apache.log4j.Logger;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;

public class DefaultUserService implements UserService {
    private static final Logger log = Logger.getLogger(DefaultUserService.class);

    private static final String PHONE_PATTERN = "\\+375(33|29|44|25)[0-9]{7}";
    private static final int MIN_PHONE_LENGTH = 13;

    @Override
    public User authorizeUser(String phoneNumber, String password) throws ServiceException, SQLException {

        if ((phoneNumber == null) || (password == null)) {
            log.info("Required fields were not filled.");
            throw new ServiceException("Заполните все поля");
        }

        DaoProvider provider = DaoProvider.getInstance();
        UserRepository userRepository = provider.getUserRepository();

        User user = userRepository.getUserByPhoneNumber(phoneNumber);
        if (user == null) {
            log.info("User with phone number " + phoneNumber + " does not exists.");
            throw new ServiceException("Пользователя с таким именем не существует!");
        }

        if (!Objects.equals(hash(password), user.getPassword())) {
            log.info("User " + phoneNumber + " enter wrong password!");
            throw new ServiceException("Wrong password! Try again.");
        }

        user.setHash(generateCode(10));
        userRepository.updateHash(user);

        log.info("Successfully authorize user:" + user);
        return user;
    }

    @Override
    public User registerUser(String phoneNumber, String password, String firstName,
                             String surname, String email) throws ServiceException, SQLException {

        if ((phoneNumber == null) || (password == null) || (firstName == null)
                || (surname == null)) {
            log.info("Required fields were not filled.");
            throw new ServiceException("Заполните обязательные поля!");
        }

        if (!Pattern.matches(PHONE_PATTERN, phoneNumber)) {
            log.info("Phone number \"" + phoneNumber + "\" does not matches regexp");
            throw new ServiceException("Неверный формат телефона!");
        }

        if (phoneNumber.length() < MIN_PHONE_LENGTH) {
            log.info("Phone number \"" + phoneNumber + "\" is too short.");
            throw new ServiceException("Телефон должен быть длиннее " + PHONE_PATTERN + " символов!");
        }

        DaoProvider provider = DaoProvider.getInstance();
        UserRepository userRepository = provider.getUserRepository();

        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            log.info("User with login " + phoneNumber + " already exists.");
            throw new ServiceException("Пользователь с таким именем уже существует!");
        }

        User user = new User();
        user.setPhoneNumber(phoneNumber);
        user.setPassword(hash(password));
        user.setHash(generateCode(10));
        user.setFirstName(firstName);
        user.setSurname(surname);
        user.setEmail(email);
        user.setRole(Role.USER);

        user = userRepository.saveUser(user);
        log.info("Successfully register user: " + user);

        return user;
    }

    @Override
    public User isAuthorized(long id, String hash) throws SQLException {
        DaoProvider provider = DaoProvider.getInstance();
        UserRepository userRepository = provider.getUserRepository();

        User user = userRepository.getUserById(id);

        return hash.equals(user.getHash()) ? user : null;
    }

    private static final String ALGORITHM = "MD5";

    private static String hash(String password) {
        try {
            String passwordHash;
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);

            md.update(password.getBytes());
            byte[] digest = md.digest();
            passwordHash = DatatypeConverter.printHexBinary(digest);

            md.update(passwordHash.getBytes());
            digest = md.digest();
            passwordHash = DatatypeConverter.printHexBinary(digest);

            return passwordHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHI JKLMNOPRQSTUVWXYZ0123456789").toCharArray();

    private static String generateCode(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int charsLen = chars.length;

        for (int i = 0; i < length; i++) {
            builder.append(chars[random.nextInt(charsLen)]);
        }

        return builder.toString();
    }
}
