package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.entity.User;
import com.util.encoder.IEncoder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;

public class AuthenticationService {
    private final static Logger LOGGER = Logger.getLogger(AuthenticationService.class);

    private DaoFactory daoFactory;
    private IEncoder encoder;

    public AuthenticationService(DaoFactory daoFactory, IEncoder encoder) {
        this.encoder = encoder;
        this.daoFactory = daoFactory;
    }

    public boolean login(HttpSession session, String email, String password) {
        User user = validate(email, encoder.encode(password));
        if(user == null) {
            return false;
        }
        else {
            session.setAttribute("currentUser", user);
            return true;
        }
    }


    public void logout(HttpSession session){
        session.invalidate();
    }


    public User validate(String email, String password){
        LOGGER.debug("validating user");
        if(email == null || password == null){
            return null;
        }
        User founded = daoFactory.getUserDao().findByEmail(email);
        if(founded == null) {
            LOGGER.debug("User not found");
            return null;
        }
        if(!founded.getPassword().equals(password)){
            LOGGER.debug("Wrong password");
            return null;
        }
        LOGGER.debug("User is valid");
        return founded;
    }
}
