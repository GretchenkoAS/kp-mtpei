package com.nyha.webfinal.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Logger logger = LogManager.getLogger();

    Router execute(HttpServletRequest request);
}
