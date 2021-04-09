package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeLocaleCommand implements Command {
    static Logger logger = LogManager.getLogger();
    public static final String PARAM_LANGUAGE = "language";
    public static final String ATTRIBUTE_LOCALE = "locale";
    private static final String ATTRIBUTE_CURRENT_PATH = "path";

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String locale = request.getParameter(PARAM_LANGUAGE);
        session.setAttribute(ATTRIBUTE_LOCALE, locale);
        String page = (String) session.getAttribute(ATTRIBUTE_CURRENT_PATH);
        Router router = new Router();
        router.setPage("index.jsp");//fixme переделать
        router.setRedirect();
        logger.debug("!!!!!!!!!   " + page);
        return router;
    }
}
