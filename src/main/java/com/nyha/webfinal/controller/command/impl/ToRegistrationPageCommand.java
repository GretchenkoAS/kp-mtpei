package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;

import javax.servlet.http.HttpServletRequest;

/**
 * The command is responsible for going to the registration page
 *
 * @author Andrey Gretchenko
 * @see Command
 */
public class ToRegistrationPageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(PagePath.REGISTRATION);
        return router;
    }
}
