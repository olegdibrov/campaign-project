package com.service.implementation;

import com.model.dao.AbstractDAO;
import com.model.dao.factory.DaoFactory;
import com.model.dao.implementation.UserDAO;
import com.model.entity.User;
import com.service.IServiceFactory;
import com.service.interfaces.IUserService;
import org.apache.log4j.Logger;

public class UserService implements IUserService {
    private final static Logger LOGGER = Logger.getLogger(UserService.class);

    private UserDAO userDAO;

    UserService(DaoFactory daoFactory) {
        userDAO = daoFactory.getUserDao();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }



}
