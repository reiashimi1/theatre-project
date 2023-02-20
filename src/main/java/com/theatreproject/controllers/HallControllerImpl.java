package com.theatreproject.controllers;

import com.theatreproject.dao.DAOFactory;
import com.theatreproject.models.Hall;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HallControllerImpl implements Controller<Hall> {
    public HallControllerImpl () {}

    private static class LazyHolder {
        static final HallControllerImpl INSTANCE = new HallControllerImpl();
    }

    public static HallControllerImpl getInstance() {
        return HallControllerImpl.LazyHolder.INSTANCE;
    }


    @Override
    public ArrayList<Hall> index() {
        return  convertToArrayList(DAOFactory.getHallDAO().index());
    }

    @Override
    public Hall show(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException("Wrong key type");
        }
        return DAOFactory.getHallDAO().show(key);
    }

    @Override
    public void store(Hall hall) {
        DAOFactory.getHallDAO().store(hall);
    }

    @Override
    public void update(Hall hall) {
        DAOFactory.getHallDAO().update(hall);
    }

    @Override
    public void destroy(Hall hall) {
        DAOFactory.getHallDAO().destroy(hall);
    }

    public <T> ArrayList<Hall> convertToArrayList(List<T> halls) {
        return halls.stream()
                .filter(object -> object instanceof Hall)
                .map(object -> (Hall) object)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
