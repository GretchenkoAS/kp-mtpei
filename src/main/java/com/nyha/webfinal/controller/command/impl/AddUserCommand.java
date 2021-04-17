package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestParameter;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddUserCommand implements Command {
    static Logger logger = LogManager.getLogger();



    private UserService service;

    public AddUserCommand(UserService service) {
        this.service = service;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String username = request.getParameter(RequestParameter.USERNAME);
        String roleStr = request.getParameter(RequestParameter.ROLE);
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
