package by.bsuir.poit.controller.command;

import by.bsuir.poit.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    private static final String HOME_COMMAND = "/home";
    private static final String NOT_FOUND_COMMAND = "/pageNotFound";
    private static final String ABOUT_COMMAND = "/about";
    private static final String AUTHORIZE_COMMAND = "/authorize";
    private static final String REGISTER_COMMAND = "/register";
    private static final String SIGN_UP_COMMAND = "/signup";
    private static final String SIGN_IN_COMMAND = "/signin";
    private static final String LOGOUT_COMMAND = "/logout";
    private static final String LOCALE_COMMAND = "/locale";

    public CommandProvider() {
        commands.put(HOME_COMMAND, new GoToHomeCommand());
        commands.put(NOT_FOUND_COMMAND, new GoToNotFoundCommand());
        commands.put(ABOUT_COMMAND, new GoToAboutPageCommand());
        commands.put(REGISTER_COMMAND, new RegisterCommand());
        commands.put(AUTHORIZE_COMMAND, new AuthorizeCommand());
        commands.put(SIGN_UP_COMMAND, new GoToSignUpCommand());
        commands.put(SIGN_IN_COMMAND, new GoToSignInCommand());
        commands.put(LOGOUT_COMMAND, new LogoutCommand());
        commands.put(LOCALE_COMMAND, new ChangeLocaleCommand());
    }

    public Command getCommand(String commandName) {
        if (commands.containsKey(commandName)) {
            return commands.get(commandName);
        } else {
            return commands.get(NOT_FOUND_COMMAND);
        }
    }
}
