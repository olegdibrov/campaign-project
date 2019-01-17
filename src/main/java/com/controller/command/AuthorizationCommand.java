package com.controller.command;

import com.controller.Pages;
import com.model.entity.Role;
import com.model.entity.User;
import com.service.implementation.AuthenticationService;
import com.service.implementation.ServiceFactory;
import com.service.implementation.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(AuthorizationCommand.class);

    private AuthenticationService authenticationService = ServiceFactory.getInstance().getAuthenticationService();
    private UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        LOGGER.debug("Authorization: remember: email: " + email);
        Role role = authenticationService.login(request.getSession(), email, pass);
        if (role == Role.USER) {
            User user = userService.getUserByEmail(email);
            request.getSession().setAttribute("user", user);
            return Pages.USER_PAGE;
        } else
            if (role == Role.ADMIN) {
                User user = userService.getUserByEmail(email);
                request.getSession().setAttribute("user", user);
                return Pages.ADMIN_PAGE;
            }
            else {
                request.setAttribute("notFound", "Email or password incorrect");
                return Pages.INDEX;
            }
    }
}

