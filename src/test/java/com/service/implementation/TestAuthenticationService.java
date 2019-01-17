package com.service.implementation;

import com.model.dao.implementation.UserDAO;
import com.model.entity.Role;
import com.model.entity.User;
import com.sun.deploy.net.HttpRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class TestAuthenticationService {
    private AuthenticationService authenticationService;
    private User testUser;

    @BeforeEach
    void init() {
        authenticationService = ServiceFactory.getInstance().getAuthenticationService();
        testUser = new User();
        testUser.setIdUser(1);
        testUser.setName("Test");
        testUser.setSurname("Test");
        testUser.setEmail("test@testtest");
        testUser.setPassword("test");
        testUser.setRole(Role.USER);
    }

    @Test
    void testValidate() {
       User result = authenticationService.validate(testUser.getEmail(), testUser.getPassword());
       Assertions.assertEquals(testUser, result);
    }

}
