package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.entity.Role;
import com.model.entity.User;
import com.util.encoder.IEncoder;
import org.apache.log4j.Logger;

public class RegistrationService {
    private final static Logger LOGGER = Logger.getLogger(UserService.class);

    private DaoFactory daoFactory;
    private IEncoder encoder;

    public RegistrationService(DaoFactory daoFactory, IEncoder encoder) {
        this.encoder = encoder;
        this.daoFactory = daoFactory;
    }

    public boolean register(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(Role.USER);
        user.setEmail(user.getEmail().toLowerCase());

        User exist = daoFactory.getUserDao().findByEmail(user.getEmail());
        if (exist == null) {
            daoFactory.getUserDao().create(user);
            return true;
        } else {
            LOGGER.debug("Can not add user, email already exist");
            return false;
        }
    }
}
