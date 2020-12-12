package by.bsuir.poit.controller.command.impl;

import by.bsuir.poit.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToSignInCommand implements Command {
    private static final Logger log = Logger.getLogger(GoToSignInCommand.class);

    private static final String SIGN_IN_PAGE = "/WEB-INF/jsp/signin.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("GoToSignInCommand execute() in session with id" + request.getSession().getId());

        RequestDispatcher dispatcher = request.getRequestDispatcher(SIGN_IN_PAGE);
        dispatcher.forward(request, response);
    }
}
