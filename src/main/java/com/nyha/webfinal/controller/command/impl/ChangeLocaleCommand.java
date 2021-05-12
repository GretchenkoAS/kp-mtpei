package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestParameter;
import com.nyha.webfinal.controller.SessionAttribute;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeLocaleCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String locale = request.getParameter(RequestParameter.LANGUAGE);
        session.setAttribute(SessionAttribute.LOCALE, locale);
        String pageName = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
        Router router = new Router();
        router.setPage(pageName);
        logger.debug("pageName " + pageName);
        return router;
    }
}
