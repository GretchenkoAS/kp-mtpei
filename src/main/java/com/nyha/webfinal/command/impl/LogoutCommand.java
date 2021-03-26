package com.nyha.webfinal.command.impl;

import com.nyha.webfinal.command.Command;
import com.nyha.webfinal.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.INDEX;
        request.getSession().invalidate(); //fixme
        return page;
    }
}
