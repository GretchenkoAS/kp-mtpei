package com.nyha.webfinal.command.impl;

import com.nyha.webfinal.command.Command;
import com.nyha.webfinal.command.PagePath;
import com.nyha.webfinal.command.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(PagePath.INDEX);
        router.setRedirect();
        HttpSession session = request.getSession();
        session.invalidate(); //fixme что это?
        return router;
    }
}
