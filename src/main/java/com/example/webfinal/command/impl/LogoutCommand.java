package com.example.webfinal.command.impl;

import com.example.webfinal.command.Command;
import com.example.webfinal.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.INDEX;
        request.getSession().invalidate();
        return page;
    }
}
