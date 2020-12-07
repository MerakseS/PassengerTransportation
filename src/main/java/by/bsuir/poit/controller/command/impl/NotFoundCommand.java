package by.bsuir.poit.controller.command.impl;

import by.bsuir.poit.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NotFoundCommand implements Command {
    private static final String NOT_FOUND_PAGE = "/WEB-INF/jsp/404.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(NOT_FOUND_PAGE);
        dispatcher.forward(request, response);
    }
}
