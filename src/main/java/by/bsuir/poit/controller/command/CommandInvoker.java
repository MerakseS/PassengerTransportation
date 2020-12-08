package by.bsuir.poit.controller.command;

import by.bsuir.poit.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private final Map<String, Command> commands = new HashMap<>();

    private static final String DEFAULT_COMMAND = "/";
    private static final String HOME_COMMAND = "/home";
    private static final String NOT_FOUND_COMMAND = "/pageNotFound";
    private static final String ABOUT_COMMAND = "/about";

    public CommandInvoker() {
        Command homeCommand = new HomeCommand();

        commands.put(DEFAULT_COMMAND, homeCommand);
        commands.put(HOME_COMMAND, homeCommand);
        commands.put(NOT_FOUND_COMMAND, new NotFoundCommand());
        commands.put(ABOUT_COMMAND, new AboutCommand());
    }

    public Command getCommand(String commandName) {
        if (commands.containsKey(commandName)) {
            return commands.get(commandName);
        } else {
            return commands.get(NOT_FOUND_COMMAND);
        }
    }
}
