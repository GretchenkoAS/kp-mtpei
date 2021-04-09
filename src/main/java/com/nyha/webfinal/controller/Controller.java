package com.nyha.webfinal.controller;

import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.CommandProvider;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    static Logger logger = LogManager.getLogger();
    public static final String COMMAND = "command";

    @Override
    public void init() {
        ConnectionPool.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandStr = request.getParameter(COMMAND);
        logger.info(commandStr);
        String pathServ = request.getServletPath();
        //logger.debug(pathServ);
        Optional<Command> commandOptional = CommandProvider.defineCommand(commandStr);
        Command command = commandOptional.orElseThrow(IllegalArgumentException::new);
        Router router = command.execute(request);
        boolean result = router.isRedirect();
        String page = router.getPage();
        if (result == false) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(page);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool.getInstance().destroyPool();
    }
}

