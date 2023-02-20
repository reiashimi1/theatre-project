package com.theatreproject.controllers;

import com.theatreproject.dao.DAOFactory;
import com.theatreproject.models.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowControllerImpl implements Controller<Show>{
    public ShowControllerImpl () {}

    private static class LazyHolder {
        static final ShowControllerImpl INSTANCE = new ShowControllerImpl();
    }

    public static ShowControllerImpl getInstance() {
        return ShowControllerImpl.LazyHolder.INSTANCE;
    }


    @Override
    public ArrayList<Show> index() {
        return convertToArrayList(DAOFactory.getShowDAO().index());
    }

    @Override
    public Show show(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException("Wrong key type");
        }
        return DAOFactory.getShowDAO().show(key);    }

    @Override
    public void store(Show show) {
        DAOFactory.getShowDAO().store(show);
    }

    @Override
    public void update(Show show) {
        DAOFactory.getShowDAO().update(show);
    }

    @Override
    public void destroy(Show show) {
        DAOFactory.getShowDAO().destroy(show);
    }

    public <T> ArrayList<Show> convertToArrayList(List<T> shows) {
        return shows.stream()
                .filter(object -> object instanceof Show)
                .map(object -> (Show) object)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
