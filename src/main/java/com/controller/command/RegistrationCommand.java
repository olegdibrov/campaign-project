package com.controller.command;

import com.controller.Pages;
import com.model.dao.factory.DaoFactory;
import com.model.entity.Role;
import com.model.entity.User;
import com.service.implementation.RegistrationService;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(RegistrationCommand.class);

    private RegistrationService registrationService = ServiceFactory.getInstance().getRegistrationService();

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
        Connection connection = DaoFactory.getInstance().getConnection();
        boolean addUser = false;
        try {
            connection.setAutoCommit(false);
            addUser = registrationService.register(user);

        } catch (SQLException e) {
            LOGGER.error("Error with registration user");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                LOGGER.error("Error with rollback registration");
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        if (addUser) {
            session.setAttribute("currentUser", user);
            return Pages.SUCCESSFUL_REGISTRATION;
        }
        else {
            request.setAttribute("notFound", "This e-mail is already used.");
            return Pages.INDEX;
        }
    }
}