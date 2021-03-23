package com.example.webfinal.command.impl;

import com.example.webfinal.command.Command;
import com.example.webfinal.command.PagePath;
import com.example.webfinal.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    static Logger logger = LogManager.getLogger();
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";

    private UserServiceImpl service;

    public LoginCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_LOGIN);
        String password = request.getParameter(PARAM_PASSWORD);
        logger.info(login);
        logger.info(password);
        logger.info(service.checkUser(login, password));
        if (service.checkUser(login, password)) {
            request.setAttribute("user", login);
            page = PagePath.MAIN;
        } else {
//            request.setAttribute("errorLoginPassMessage",
//                    MessageManager.getProperty("message.loginerror"));
//            page = ConfigurationManager.getProperty("path.page.login");
            page = PagePath.LOGIN;
        }
        return page;
    }
}
