package by.bsuir.poit.controller.command.impl;

import by.bsuir.poit.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAboutPageCommand implements Command {
    private static final Logger log = Logger.getLogger(GoToAboutPageCommand.class);

    private static final String ABOUT_PAGE = "/WEB-INF/jsp/about.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("GoToAboutPageCommand execute() in session with id" + request.getSession().getId());

        RequestDispatcher dispatcher = request.getRequestDispatcher(ABOUT_PAGE);
        dispatcher.forward(request, response);
    }
}
