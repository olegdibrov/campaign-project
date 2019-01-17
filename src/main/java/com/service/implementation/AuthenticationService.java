package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.dao.implementation.UserDAO;
import com.model.entity.Role;
import com.model.entity.User;
import com.service.interfaces.IAuthenticationService;
import com.util.encoder.IEncoder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;

public class AuthenticationService implements IAuthenticationService {
    private final static Logger LOGGER = Logger.getLogger(AuthenticationService.class);

    private UserDAO userDAO;
    private IEncoder encoder;

    public AuthenticationService(DaoFactory daoFactory, IEncoder encoder) {
        this.encoder = encoder;
        userDAO = daoFactory.getUserDao();
    }

    @Override
    public Role login(HttpSession session, String email, String password) {
        User user = validate(email, encoder.encode(password));
        if (user == null) {
            return Role.UNKNOWN;
        } else {
            session.setAttribute("currentUser", user);
            return user.getRole();
        }
    }


    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }


    @Override
    public User validate(String email, String password) {
        LOGGER.debug("validating user");
        if (email == null || password == null) {
            return null;
        }
        User founded = userDAO.findByEmail(email);
        if (founded == null) {
            LOGGER.debug("User not found");
            return null;
        }
        if (!founded.getPassword().equals(password)) {
            LOGGER.debug("Wrong password");
            return null;
        }
        LOGGER.debug("User is valid");
        return founded;
    }
}
