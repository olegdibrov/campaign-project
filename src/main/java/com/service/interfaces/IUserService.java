package com.service.interfaces;

import com.model.entity.User;

public interface IUserService {
    User getUserByEmail(String email);
}
