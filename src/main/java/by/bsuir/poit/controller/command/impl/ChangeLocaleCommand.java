package by.bsuir.poit.controller.command.impl;

import by.bsuir.poit.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLocaleCommand implements Command {
    private static final Logger log = Logger.getLogger(AuthorizeCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("ChangeLocaleCommand execute() in session with id" + request.getSession().getId());

        request.getSession(true).setAttribute("local", request.getParameter("local"));
        response.sendRedirect("home");
    }
}
