package by.bsuir.poit.dao.impl;

import by.bsuir.poit.dao.UserRepository;
import by.bsuir.poit.entity.Role;
import by.bsuir.poit.entity.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

import static java.lang.String.format;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class DefaultUserRepository implements UserRepository {
    private static final String DATA_SOURCE_NAME = "java:/comp/env/jdbc/postgres";
    private static DataSource dataSource;

    private static final String SELECT_BY_PHONE_QUERY = "SELECT * FROM users WHERE phone = ?";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String SAVE_USER_QUERY = "INSERT INTO users(phone, password," +
            " user_hash, firstname, surname, email, role) VALUES (?, ?, ?, ?, ?, ?, ?::role_type)";
    private static final String UPDATE_HASH_QUERY = "UPDATE users SET user_hash = ? WHERE id = ?";

    public DefaultUserRepository() {
        try {
            InitialContext cxt = new InitialContext();
            dataSource = (DataSource) cxt.lookup(DATA_SOURCE_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User saveUser(User user) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_USER_QUERY, RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getPhoneNumber());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getHash());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getSurname());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getRole().toString());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException(format("Can't save user. No rows affected. User: %s", user));
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException(format("Can't save user. No ID obtained. User: %s", user));
                }
            }

            return user;
        }
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_PHONE_QUERY)) {

            statement.setString(1, phoneNumber);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setPhoneNumber(resultSet.getString("phone"));
                    user.setPassword(resultSet.getString("password"));
                    user.setHash(resultSet.getString("user_hash"));
                    user.setFirstName(resultSet.getString("firstname"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setRole(Role.valueOf(resultSet.getString("role")));
                    return user;
                }
                return null;
            }
        }
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_PHONE_QUERY)) {

            statement.setString(1, phoneNumber);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    @Override
    public void updateHash(User user) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_HASH_QUERY)) {

            statement.setString(1, user.getHash());
            statement.setLong(2, user.getId());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Can't update user. User: " + user);
            }
        }
    }

    @Override
    public User getUserById(long id) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setPhoneNumber(resultSet.getString("phone"));
                    user.setPassword(resultSet.getString("password"));
                    user.setHash(resultSet.getString("user_hash"));
                    user.setFirstName(resultSet.getString("firstname"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setRole(Role.valueOf(resultSet.getString("role")));
                    return user;
                }
                return null;
            }
        }    }
}
