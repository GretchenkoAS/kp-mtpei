package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.model.service.UserService;
import com.nyha.webfinal.resource.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class AddUserCommand implements Command {
    static Logger logger = LogManager.getLogger();
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_USERNAME = "username";
    private static final String PARAM_ROLE = "role";


    private UserService service;

    public AddUserCommand(UserService service) {
        this.service = service;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String email = request.getParameter(PARAM_EMAIL);
        String password = request.getParameter(PARAM_PASSWORD);
        String username = request.getParameter(PARAM_USERNAME);
        String roleStr = request.getParameter(PARAM_ROLE);
        User.Role role = User.Role.valueOf(roleStr);
        User user = new User();
        //fixme сделать юзера

        try {
            boolean isAdd = service.addUser(user, password);
            //fixme оделать

        } catch (ServiceException e) {
            logger.error("registration error", e);
        }
        return router;
    }
}
