package by.bsuir.poit.service;

import by.bsuir.poit.entity.User;
import java.sql.SQLException;

public interface UserService {

    User authorizeUser (String phoneNumber, String password) throws ServiceException, SQLException;

    public User registerUser(String phoneNumber, String password, String firstName,
                             String surname, String email) throws ServiceException, SQLException;

    User isAuthorized(long id, String hash) throws SQLException;
}
