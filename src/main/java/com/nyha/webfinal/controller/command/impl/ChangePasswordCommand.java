package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.RequestParameter;
import com.nyha.webfinal.controller.SessionAttribute;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.model.service.UserService;
import com.nyha.webfinal.model.service.impl.UserServiceImpl;
import com.nyha.webfinal.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class ChangePasswordCommand implements Command {
    public static final String INCORRECT_PASSWORD = "incorrectPassword";
    private UserService service = new UserServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(PagePath.PROFILE);
        HttpSession session = request.getSession(true);
        User user = (User)session.getAttribute(SessionAttribute.USER);
        String email = user.getEmail();
        String password = request.getParameter(RequestParameter.PASSWORD);
        String newPassword = request.getParameter(RequestParameter.NEW_PASSWORD);
        try {
            Optional<User> userOptional = service.findUserByEmailAndPassword(email, password);
            if (userOptional.isPresent() && UserValidator.isValidPassword(newPassword)) {
                String message = service.changePassword(user, newPassword);
                request.setAttribute(RequestAttribute.MESSAGE, message);
                router.setRedirect();
            } else {
                request.setAttribute(RequestAttribute.INCORRECT_DATA, INCORRECT_PASSWORD);
            }
        } catch (ServiceException e) {
            logger.error("change password error, " + newPassword, e);
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e);
        }
        return router;
    }
}