package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowUsersCommand implements Command {
    static Logger logger = LogManager.getLogger();
    private UserService service;
    private static final String ATTRIBUTE_NAME_USERS = "users";
    public static final String EXCEPTION = "Exception";

    public ShowUsersCommand(UserService service) {
        this.service = service;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(PagePath.USERS);
        List<User> users;
        try {
            users = service.findAllUsers();
            request.setAttribute(ATTRIBUTE_NAME_USERS, users);
        } catch (ServiceException e) {
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(EXCEPTION, e.getMessage());
            logger.error("search error",e);
        }
        return router;
    }
}
