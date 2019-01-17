package com.controller.command;

import com.controller.Pages;
import com.service.implementation.AuthenticationService;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(LogoutCommand.class);

    private AuthenticationService authenticationService = ServiceFactory.getInstance().getAuthenticationService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            authenticationService.logout(request.getSession());
        } catch (Exception e) {
            LOGGER.error("Some error with logout");
            return Pages.ERROR;
        }
        return Pages.INDEX;
    }
}
