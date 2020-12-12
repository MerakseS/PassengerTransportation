package by.bsuir.poit.dao;

import by.bsuir.poit.entity.User;

import java.sql.SQLException;

public interface UserRepository {

    boolean existsByPhoneNumber(String login) throws SQLException;

    User saveUser(User user) throws SQLException;

    User getUserByPhoneNumber(String phoneNumber) throws SQLException;

    void updateHash(User user) throws SQLException;

    User getUserById(long id) throws SQLException;
}
