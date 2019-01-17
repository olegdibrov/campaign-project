package com.service.interfaces;

import com.model.dao.factory.DaoFactory;
import com.model.entity.Role;
import com.model.entity.User;

import javax.servlet.http.HttpSession;

public interface IAuthenticationService {
    Role login(HttpSession session, String email, String password);
    void logout(HttpSession session);
    User validate(String email, String password);
}
