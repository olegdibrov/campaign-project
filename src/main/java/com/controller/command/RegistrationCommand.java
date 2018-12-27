package com.controller.command;

import com.model.entity.Role;
import com.model.entity.User;
import com.service.implementation.ServiceFactory;
import com.util.Pages;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("name");
        String secondName = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LOGGER.debug("Registration: " + firstName + " " + secondName + " " + email);


        User user = new User();
        user.setName(firstName);
        user.setSurname(secondName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.USER);
        boolean addUser = ServiceFactory.getInstance().getRegistrationService().register(user);
        if (addUser) {

            return Pages.SUCCESSFUL_REGISTRATION;
        }
        else return Pages.INDEX;
    }
}