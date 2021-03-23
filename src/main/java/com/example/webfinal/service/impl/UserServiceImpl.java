package com.example.webfinal.service.impl;

import com.example.webfinal.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean checkUser(String login, String password) {
        return login.equals("1") && password.equals("1");
    }
}
