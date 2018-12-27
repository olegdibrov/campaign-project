package com.controller.command;

import com.service.implementation.ServiceFactory;
import com.util.Pages;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(AuthenticationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
      //  String remember = request.getParameter("inputRemember");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
      //  LOGGER.debug("Authorization: remember: " + remember + " email: " + email);
        boolean login = ServiceFactory.getInstance().getAuthenticationService().login(request.getSession(), email, pass);
        if (login == true) {
            return Pages.USER_PAGE;
        } else
            return Pages.INDEX;
    }
}


//        if("on".equals(remember)) {
//            Cookie emailCookie = new Cookie("email", email);
//            Cookie passCookie = new Cookie("pass",
//                    ((User) request.getSession().getAttribute(SessionParameters.USER)).getPassword());
//
//            emailCookie.setMaxAge(SessionParameters.COOKIES_MAX_AGE);
//            passCookie.setMaxAge(SessionParameters.COOKIES_MAX_AGE);
//            response.addCookie( emailCookie );
//            response.addCookie( passCookie );
//        }
//


