package com.theatreproject.dao;

import java.util.List;

public interface DAO<T> {

    public List<T> index();

    public T show(Object key);

    public void store(T entity);

    public void update(T entity);

    public void destroy(T entity);

}