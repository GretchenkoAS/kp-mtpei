package com.nyha.webfinal.command.impl;

import com.nyha.webfinal.command.Command;
import com.nyha.webfinal.command.PagePath;
import com.nyha.webfinal.entity.User;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowUsersCommand implements Command {
    static Logger logger = LogManager.getLogger();
    private UserService service;
    public ShowUsersCommand(UserService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.USERS;
        List<User> users = null;
        try {
            users = service.findAllUsers();
        } catch (ServiceException e) {
            logger.error(e);
            e.printStackTrace();
        }
        request.setAttribute("users", users);
        return page;
    }
}
