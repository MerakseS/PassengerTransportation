package by.bsuir.poit.controller.command.impl;

import by.bsuir.poit.controller.command.Command;
import by.bsuir.poit.entity.User;
import by.bsuir.poit.service.ServiceException;
import by.bsuir.poit.service.ServiceProvider;
import by.bsuir.poit.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterCommand implements Command {
    private static final Logger log = Logger.getLogger(RegisterCommand.class);

    private static final String PHONE_NUMBER_PARAMETER = "phone";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String FIRSTNAME_PARAMETER = "firstname";
    private static final String SURNAME_PARAMETER = "surname";
    private static final String EMAIL_PARAMETER = "email";

    private static final String MAIN_PAGE = "home";
    private static final String SIGN_UP_PAGE = "signup";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("RegisterCommand execute() in session with id" + request.getSession().getId());

        String phoneNumber = request.getParameter(PHONE_NUMBER_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);
        String firstName = request.getParameter(FIRSTNAME_PARAMETER);
        String surname = request.getParameter(SURNAME_PARAMETER);
        String email = request.getParameter(EMAIL_PARAMETER);

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();
        String page;

        try {
            User user = userService.registerUser(phoneNumber, password, firstName, surname, email);
            request.setAttribute("user", user);
            page = MAIN_PAGE;
        } catch (ServiceException | SQLException e) {
            request.setAttribute("error", e.getMessage());
            page = SIGN_UP_PAGE;
        }

        response.sendRedirect(page);
    }
}
