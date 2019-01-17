package com.controller.command;

import com.controller.Pages;
import com.model.entity.Role;
import com.model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToCabinet implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(GoToCabinet.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user;
        try {
            user = (User) request.getSession().getAttribute("currentUser");
        } catch (NullPointerException ex) {
            return Pages.ACCESS_DENIED;
        }
        if (user.getRole() == Role.ADMIN) {
            return Pages.ADMIN_PAGE;
        } else return Pages.USER_PAGE;
    }
}
