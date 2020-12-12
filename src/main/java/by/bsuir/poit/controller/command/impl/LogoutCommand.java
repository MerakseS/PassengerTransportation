package by.bsuir.poit.controller.command.impl;

import by.bsuir.poit.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.bsuir.poit.controller.Controller.getCookie;

public class LogoutCommand implements Command {

    private static final String MAIN_PAGE = "home";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie idCookie = getCookie(request, "id");
        Cookie hashCookie = getCookie(request, "hash");

        if (idCookie != null) {
            idCookie.setMaxAge(0);
            response.addCookie(idCookie);
        }

        if (hashCookie != null) {
            hashCookie.setMaxAge(0);
            response.addCookie(hashCookie);
        }

        response.sendRedirect(MAIN_PAGE);
    }
}
