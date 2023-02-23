package com.theatreproject.controllers;

import com.theatreproject.dao.DAOFactory;
import com.theatreproject.models.User;

public class UserControllerImpl {
    public UserControllerImpl () {}

    private static class LazyHolder {
        static final UserControllerImpl INSTANCE = new UserControllerImpl();
    }

    public static UserControllerImpl getInstance() {
        return UserControllerImpl.LazyHolder.INSTANCE;
    }

    public User authenticate(String username, String password) {
        return DAOFactory.getUserDAO().authenticate(username, password);
    }
}

