//package com.nyha.webfinal.controller.filter;
//
//import com.nyha.webfinal.controller.command.PagePath;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
////fixme как сделать лучше?
//@WebFilter(filterName = "JspPagePathFilter", urlPatterns = "/pages/*")
//public class JspPagePathFilter implements Filter {
//    static Logger logger = LogManager.getLogger();
//
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        logger.info("jsp page path filter");
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpResponse.sendRedirect(httpRequest.getContextPath() + PagePath.INDEX);
//        chain.doFilter(request, response);
//    }
//}
