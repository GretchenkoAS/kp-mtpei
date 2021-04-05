package com.nyha.webfinal.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Router execute(HttpServletRequest request);
}
