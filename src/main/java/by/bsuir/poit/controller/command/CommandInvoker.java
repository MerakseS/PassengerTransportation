package by.bsuir.poit.controller.command;

import by.bsuir.poit.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private final Map<String, Command> commands = new HashMap<>();

    private static final String HOME_COMMAND = "home";
    private static final String NOT_FOUND_COMMAND = "notFound";

    public CommandInvoker() {
        commands.put(HOME_COMMAND, new HomeCommand());
        commands.put(NOT_FOUND_COMMAND, new NotFoundCommand());
    }

    public Command getCommand(String commandName) {
        if (commands.containsKey(commandName)) {
            return commands.get(commandName);
        } else {
            return commands.get(NOT_FOUND_COMMAND);
        }
    }
}
