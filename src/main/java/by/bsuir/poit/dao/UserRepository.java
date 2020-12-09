package by.bsuir.poit.dao;

import by.bsuir.poit.entity.User;

import java.sql.SQLException;

public interface UserRepository {

    boolean existsByLogin(String login);

    User saveUser(User user);
}
