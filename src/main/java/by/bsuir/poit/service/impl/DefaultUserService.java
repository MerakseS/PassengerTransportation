package by.bsuir.poit.service.impl;

import by.bsuir.poit.dao.DaoProvider;
import by.bsuir.poit.dao.UserRepository;
import by.bsuir.poit.entity.User;
import by.bsuir.poit.service.ServiceException;
import by.bsuir.poit.service.UserService;
import org.apache.log4j.Logger;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class DefaultUserService implements UserService {
    private static final Logger log = Logger.getLogger(DefaultUserService.class);

    private static final String PHONE_PATTERN = "\\+375(33|29|44|25)[0-9]{7}";
    private static final int MIN_PHONE_LENGTH = 3;

    @Override
    public User authorizeUser(String phoneNumber, String password) {
        return null;
    }

    @Override
    public User registerUser(String phoneNumber, String password, String firstName,
                             String surname, String email) throws ServiceException {

        if ((phoneNumber == null) || (password == null) || (firstName == null)
                || (surname == null)) {
            log.info("Required fields were not filled.");
            throw new ServiceException("Заполните обязательные поля!");
        }

        if (!Pattern.matches(PHONE_PATTERN, phoneNumber)) {
            log.info("Phone number \"" + phoneNumber + "\" does not matches regexp");
            throw new ServiceException("Логин должен содержать только латинские буквы и цифры!");
        }

        if (phoneNumber.length() < MIN_PHONE_LENGTH) {
            log.info("Phone number \"" + phoneNumber + "\" is too short.");
            throw new ServiceException("Логин должен быть длиннее двух символов!");
        }

        DaoProvider provider = DaoProvider.getInstance();
        UserRepository userRepository = provider.getUserRepository();

        if(userRepository.existsByLogin(phoneNumber)) {
            log.info("User with login " + phoneNumber + " already exists.");
            throw new ServiceException("Пользователь с таким именем уже существует!");
        }

        String passwordHash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            passwordHash = DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User user = new User();

        user.setPhoneNumber(phoneNumber);
        user.setPasswordHash(passwordHash);
        user.setFirstName(firstName);
        user.setSurname(surname);
        user.setEmail(email);

        user = userRepository.saveUser(user);
        log.info("Successfully register user: " + user);

        return user;
    }
}
