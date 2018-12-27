package com.controller.command;

import com.service.implementation.ServiceFactory;
import com.util.Pages;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(LogoutCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
            try {
                ServiceFactory.getInstance().getAuthenticationService().logout(request.getSession());
            } catch (Exception e) {
                LOGGER.error("Some error with logout");
                return Pages.INDEX;
            }
            return Pages.INDEX;
    }
}
