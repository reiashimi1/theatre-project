package com.theatreproject.controllers;

import java.util.ArrayList;

public interface Controller<T> {

    ArrayList<T> index();

    T show(Object key);

    void store(T entity);

    void update(T entity);

    void destroy(T entity);

}
