package com.service.implementation;

import com.model.entity.Role;
import com.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRegistrationService {
    private RegistrationService registrationService;
    private UserService userService;
    private User testUser;

    @BeforeEach
    void init() {
        registrationService = ServiceFactory.getInstance().getRegistrationService();
        userService = ServiceFactory.getInstance().getUserService();
        testUser = new User();
        testUser.setIdUser(1);
        testUser.setName("Test");
        testUser.setSurname("Test");
        testUser.setEmail("test@testtest");
        testUser.setPassword("test");
        testUser.setRole(Role.USER);
    }

    @Test
    void register() {
       registrationService.register(testUser);
       User result = userService.getUserByEmail(testUser.getEmail());
        Assertions.assertEquals(testUser, result);
    }

}
