package com.service.implementation;

import com.model.dao.AbstractDAO;
import com.model.dao.factory.DaoFactory;
import com.service.IServiceFactory;
import org.apache.log4j.Logger;

public class UserService {
    private final static Logger LOGGER = Logger.getLogger(UserService.class);

    private DaoFactory daoFactory;

    public UserService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }



}
