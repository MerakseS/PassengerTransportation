package by.bsuir.poit.controller.command.impl;

import by.bsuir.poit.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeCommand implements Command {
    private static final String MAIN_PAGE = "/WEB-INF/jsp/main.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(request, response);
    }
}
