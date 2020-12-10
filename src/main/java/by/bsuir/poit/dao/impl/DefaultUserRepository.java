package by.bsuir.poit.dao.impl;

import by.bsuir.poit.dao.UserRepository;
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

    private static final String SELECT_BY_PHONE_QUERY = "SELECT * FROM users WHERE phone_number = ?";
    private static final String SAVE_USER_QUERY = "INSERT INTO users(first_name, surname, " +
            "phone_number, email, password_hash) VALUES (?, ?, ?, ?, ?)";

    public DefaultUserRepository() {
        try {
            InitialContext cxt = new InitialContext();
            dataSource = (DataSource) cxt.lookup(DATA_SOURCE_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existsByLogin(String phoneNumber) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_PHONE_QUERY)) {

            statement.setString(1, phoneNumber);

            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            }
        }
    }

    @Override
    public User saveUser(User user) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_USER_QUERY, RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPhoneNumber());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPasswordHash());

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
}
