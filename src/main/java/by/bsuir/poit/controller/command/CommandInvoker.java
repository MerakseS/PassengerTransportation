package by.bsuir.poit.controller.command;

import by.bsuir.poit.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private final Map<String, Command> commands = new HashMap<>();

    private static final String HOME_COMMAND = "home";
    private static final String NOT_FOUND_COMMAND = "notfound";
    private static final String ABOUT_COMMAND = "about";

    public CommandInvoker() {
        commands.put(HOME_COMMAND, new HomeCommand());
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
