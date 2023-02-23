package com.theatreproject.dao;

import com.theatreproject.models.User;

public interface UserDAO{

    public User authenticate (String username, String password);
}
