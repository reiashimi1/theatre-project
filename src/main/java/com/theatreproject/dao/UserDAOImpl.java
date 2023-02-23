package com.theatreproject.dao;

import com.theatreproject.models.User;
import com.theatreproject.utils.EntityManagerProvider;

import java.util.List;

public class UserDAOImpl implements UserDAO{

    @Override
    public User authenticate(String username, String password) {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("User.authenticate", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
    }
}
