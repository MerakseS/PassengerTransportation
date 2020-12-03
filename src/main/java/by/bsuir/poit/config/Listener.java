package by.bsuir.poit.config;

import org.flywaydb.core.Flyway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseProperties databaseProperties = new DatabaseProperties();
        runFlyway(
                databaseProperties.getUrl(),
                databaseProperties.getUser(),
                databaseProperties.getPassword()
        );
    }

    private static void runFlyway(String url, String user, String password) {
        Flyway.
                configure().
                dataSource(url, user, password).
                load().
                migrate();
    }
}
