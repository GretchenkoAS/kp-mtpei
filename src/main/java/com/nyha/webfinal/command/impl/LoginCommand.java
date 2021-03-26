package com.nyha.webfinal.command.impl;

import com.nyha.webfinal.command.Command;
import com.nyha.webfinal.command.PagePath;
import com.nyha.webfinal.entity.User;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoginCommand implements Command {
    static Logger logger = LogManager.getLogger();
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_PASSWORD = "password";

    private UserService service;

    public LoginCommand(UserService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String email = request.getParameter(PARAM_EMAIL);
        String password = request.getParameter(PARAM_PASSWORD);
        try {
            Optional<User> user = service.findUserByEmailAndPassword(email, password);
            if (user.isPresent()) {
                List<User> users = new ArrayList<>();
                users.add(user.get());
                request.setAttribute("users", users);
                page = PagePath.MAIN;
            } else {
//            request.setAttribute("errorLoginPassMessage",
//                    MessageManager.getProperty("message.loginerror")); //fixme
//            page = ConfigurationManager.getProperty("path.page.login");
                page = PagePath.LOGIN;
            }
        } catch (ServiceException e) {
            logger.error(e);
            e.printStackTrace();
        }

        return page;
    }
}
