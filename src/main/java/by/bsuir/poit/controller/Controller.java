package by.bsuir.poit.controller;

import by.bsuir.poit.controller.command.Command;
import by.bsuir.poit.controller.command.CommandInvoker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    private static final String COMMAND_PARAMETER = "command";

    CommandInvoker commandInvoker = new CommandInvoker();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getRequestURI();
        Command command = commandInvoker.getCommand(commandName);
        command.execute(request, response);
    }
}
