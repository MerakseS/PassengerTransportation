package by.bsuir.poit.controller;

import by.bsuir.poit.config.DatabaseProperties;
import org.flywaydb.core.Flyway;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    private static DatabaseProperties databaseProperties;

//    @Override
//    public void init() throws ServletException {
//        databaseProperties = new DatabaseProperties();
//        runFlyway(
//                databaseProperties.getUrl(),
//                databaseProperties.getUser(),
//                databaseProperties.getPassword()
//        );
//
//        super.init();
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println(databaseProperties.getUrl());
        writer.println(databaseProperties.getUser());
        writer.println(databaseProperties.getPassword());
        writer.println("</html>");
    }

//    private static void runFlyway(String url, String user, String password) {
//        Flyway.
//                configure().
//                dataSource(url, user, password).
//                load().
//                migrate();
//    }
}
