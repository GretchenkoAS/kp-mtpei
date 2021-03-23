package com.example.webfinal.controller;

import com.example.webfinal.command.Command;
import com.example.webfinal.command.CommandProvider;
import com.example.webfinal.command.PagePath;
import com.example.webfinal.entity.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    static Logger logger = LogManager.getLogger();
    public static final String COMMAND = "command";

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void destroy() {
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandStr = request.getParameter(COMMAND);
        logger.info(commandStr);
        Optional<Command> commandOptional = CommandProvider.defineCommand(commandStr);
        Command command = commandOptional.orElseThrow(IllegalArgumentException::new);
        String page = command.execute(request);
        logger.info(page);
        if(page != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
//            request.getSession().setAttribute("nullPage",
//                    MessageManager.getProperty("message.nullpage"));
//            response.sendRedirect(request.getContextPath() + page);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.LOGIN);
            dispatcher.forward(request, response);
        }
    }
}

