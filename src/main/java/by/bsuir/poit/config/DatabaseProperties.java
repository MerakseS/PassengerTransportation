package by.bsuir.poit.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseProperties {
    private static final String HOST_PROPERTY_NAME = "db.host";
    private static final String DB_NAME_PROPERTY_NAME = "db.name";
    private static final String USER_PROPERTY_NAME = "db.user";
    private static final String PASSWORD_PROPERTY_NAME = "db.password";

    private static final String DEFAULT_DB_HOST = "localhost:5432";
    private static final String DEFAULT_DB_NAME = "passenger_transportation_db";
    private static final String DEFAULT_DB_USER = "postgres";
    private static final String DEFAULT_DB_PASSWORD = "postgres";

    private static final String DB_URL_FORMAT = "jdbc:postgresql://%s/%s";
    private static final String PROPERTIES_FILE_NAME = "/db.properties";

    private final String url;
    private final String user;
    private final String password;

    public DatabaseProperties() {
        Properties properties = new Properties();
        String dbHost;
        String dbName;
        String dbUser;
        String dbPassword;

        try (InputStream is = DatabaseProperties.class.getResourceAsStream(PROPERTIES_FILE_NAME)) {
            properties.load(is);

            dbHost = properties.getProperty(HOST_PROPERTY_NAME);
            dbName = properties.getProperty(DB_NAME_PROPERTY_NAME);
            dbUser = properties.getProperty(USER_PROPERTY_NAME);
            dbPassword = properties.getProperty(PASSWORD_PROPERTY_NAME);
        } catch (IOException e) {
            dbHost = DEFAULT_DB_HOST;
            dbName = DEFAULT_DB_NAME;
            dbUser = DEFAULT_DB_USER;
            dbPassword = DEFAULT_DB_PASSWORD;
            e.printStackTrace();
        }

        url = String.format(DB_URL_FORMAT, dbHost, dbName);
        user = dbUser;
        password = dbPassword;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
