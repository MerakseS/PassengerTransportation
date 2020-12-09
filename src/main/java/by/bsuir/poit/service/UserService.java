package by.bsuir.poit.service;

import by.bsuir.poit.entity.User;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    User authorizeUser (String phoneNumber, String password);

    public User registerUser(String phoneNumber, String password, String firstName,
                             String surname, String email) throws ServiceException;
}
