package by.bsuir.poit.controller;

import by.bsuir.poit.controller.command.Command;
import by.bsuir.poit.controller.command.CommandProvider;
import by.bsuir.poit.entity.User;
import by.bsuir.poit.service.ServiceProvider;
import by.bsuir.poit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Controller")
public class Controller extends HttpServlet {

    CommandProvider commandProvider = new CommandProvider();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getRequestURI();
        Command command = commandProvider.getCommand(commandName);
        command.execute(request, response);
    }

    public static User checkAuthorization(HttpServletRequest request, HttpServletResponse response) {
        Cookie idCookie = getCookie(request, "id");
        Cookie hashCookie = getCookie(request, "hash");

        if ((idCookie == null) || (hashCookie == null)) {
            return null;
        }

        long id = Long.parseLong(idCookie.getValue());
        String hash = hashCookie.getValue();
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        try {
            return userService.isAuthorized(id, hash);
        } catch (SQLException e) {
            return null;
        }
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
