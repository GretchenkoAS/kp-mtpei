package com.nyha.webfinal.controller.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "HeaderFilter", urlPatterns = "*.jsp")
public class HeaderFilter implements Filter {
    static Logger logger = LogManager.getLogger();

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String referer = req.getHeader("referer");
        String uri = req.getRequestURI();
        String path = req.getServletPath();
        StringBuffer url =req.getRequestURL();
        String query = req.getQueryString();
        HttpSession session = req.getSession();
        session.setAttribute("current_referer", referer);
        session.setAttribute("request_uri", uri);
        session.setAttribute("path", path);
        session.setAttribute("url", url.toString());
        session.setAttribute("query", query);
        logger.debug(path);
        chain.doFilter(request, response);
    }
}
