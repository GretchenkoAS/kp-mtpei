package com.nyha.webfinal.command;

import com.nyha.webfinal.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request);
}
