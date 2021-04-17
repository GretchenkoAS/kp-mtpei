package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.RequestParameter;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.service.UserService;
import com.nyha.webfinal.resource.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements Command {
    static Logger logger = LogManager.getLogger();
    private static final String ATTRIBUTE_NAME_ERROR_LOGIN = "error_login";

    private UserService service;

    public LoginCommand(UserService service) {
        this.service = service;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);
        try {
            Optional<User> user = service.findUserByEmailAndPassword(email, password);
            if (user.isPresent()) {
                request.setAttribute(RequestAttribute.USER, user.get().getUsername());
                router.setPage(PagePath.MAIN);
            } else {
                request.setAttribute(RequestAttribute.ERROR_LOGIN, MessageManager.getProperty("message.error_login"));//fixme что-то с этим придумать
                router.setPage(PagePath.LOGIN);
            }
        } catch (ServiceException e) {
            logger.error("login error", e);
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e);
        }
        return router;
    }
}
