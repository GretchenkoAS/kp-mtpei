package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.model.service.UserService;
import com.nyha.webfinal.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToUsersPageCommand implements Command {
    static Logger logger = LogManager.getLogger();
    private UserService service  = new UserServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        List<User> users;
        try {
            users = service.findAllUsers();
            request.setAttribute(RequestAttribute.USERS, users);
            router.setPage(PagePath.USERS);
        } catch (ServiceException e) {
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e.getMessage());
            logger.error("search error",e);
        }
        return router;
    }
}
