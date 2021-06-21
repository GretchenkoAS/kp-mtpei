package com.nyha.webfinal.controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The interface for different commands
 *
 * @author Andrey Gretchenko
 */
public interface Command {

    /**
     * Executes command
     *
     * @param request {@link HttpServletRequest}
     * @return {@link Router}
     */
    Router execute(HttpServletRequest request);
}
