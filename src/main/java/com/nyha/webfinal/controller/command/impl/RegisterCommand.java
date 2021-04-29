package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.RequestParameter;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class RegisterCommand implements Command {
    static Logger logger = LogManager.getLogger();

    private UserService service;

    public RegisterCommand(UserService service) {
        this.service = service;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String username = request.getParameter(RequestParameter.USERNAME);
        String roleStr = request.getParameter(RequestParameter.ROLE);
        User.Role role = User.Role.valueOf(roleStr.toUpperCase());
        User user = new User(username, email, role);
        try {
            Optional<String> error = service.addUser(user, password);
            if(error.isEmpty()) {
                router.setPage(PagePath.MAIN);
            }
            else {
                request.setAttribute(RequestAttribute.INCORRECT_LOGIN, error.get());
                router.setPage(PagePath.REGISTRATION);
            }
        } catch (ServiceException e) {
            logger.error("registration error", e);
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e);
        }
        return router;
    }

}
