package by.bsuir.poit.dao.impl;

import by.bsuir.poit.dao.UserRepository;
import by.bsuir.poit.entity.User;

public class DefaultUserRepository implements UserRepository {
    @Override
    public boolean existsByLogin(String login) {
        return false;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }
}
