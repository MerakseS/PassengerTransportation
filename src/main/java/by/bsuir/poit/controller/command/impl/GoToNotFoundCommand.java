package by.bsuir.poit.controller.command.impl;

import by.bsuir.poit.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToNotFoundCommand implements Command {
    private static final Logger log = Logger.getLogger(GoToNotFoundCommand.class);

    private static final String NOT_FOUND_PAGE = "/WEB-INF/jsp/404.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("GoToNotFoundCommand execute() in session with id" + request.getSession().getId());

        RequestDispatcher dispatcher = request.getRequestDispatcher(NOT_FOUND_PAGE);
        dispatcher.forward(request, response);
    }
}
