package com.theatreproject.controllers;

import com.theatreproject.dao.DAOFactory;
import com.theatreproject.models.Play;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayControllerImpl implements Controller<Play> {
    public PlayControllerImpl () {}

    private static class LazyHolder {
        static final PlayControllerImpl INSTANCE = new PlayControllerImpl();
    }

    public static PlayControllerImpl getInstance() {
        return PlayControllerImpl.LazyHolder.INSTANCE;
    }

    @Override
    public ArrayList<Play> index() {
        return convertToArrayList(DAOFactory.getPlayDAO().index());
    }

    @Override
    public Play show(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException("Wrong key type");
        }
        return DAOFactory.getPlayDAO().show(key);
    }

    @Override
    public void store(Play play) {
        DAOFactory.getPlayDAO().store(play);
    }

    @Override
    public void update(Play play) {
        DAOFactory.getPlayDAO().update(play);
    }

    @Override
    public void destroy(Play play) {
        DAOFactory.getPlayDAO().destroy(play);
    }

    public <T> ArrayList<Play> convertToArrayList(List<T> plays) {
        return plays.stream()
                .filter(object -> object instanceof Play)
                .map(object -> (Play) object)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
