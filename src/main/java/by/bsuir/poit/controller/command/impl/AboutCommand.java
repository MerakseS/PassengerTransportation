package by.bsuir.poit.controller.command.impl;

import by.bsuir.poit.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AboutCommand implements Command {
    private static final String ABOUT_PAGE = "/WEB-INF/jsp/about.jsp";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(ABOUT_PAGE);
        dispatcher.forward(request, response);
    }
}
