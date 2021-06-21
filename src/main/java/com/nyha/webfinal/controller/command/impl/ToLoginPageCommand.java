package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;

import javax.servlet.http.HttpServletRequest;

/**
 * The command is responsible for going to the login page
 *
 * @author Andrey Gretchenko
 * @see Command
 */
public class ToLoginPageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(PagePath.LOGIN);
        return router;
    }
}
