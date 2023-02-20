package com.theatreproject.controllers;

import com.theatreproject.dao.DAOFactory;
import com.theatreproject.models.Actor;
import com.theatreproject.models.Play;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActorControllerImpl implements Controller<Actor> {

    public ActorControllerImpl () {}

    private static class LazyHolder {
        static final ActorControllerImpl INSTANCE = new ActorControllerImpl();
    }

    public static ActorControllerImpl getInstance() {
        return ActorControllerImpl.LazyHolder.INSTANCE;
    }

    @Override
    public ArrayList<Actor> index() {
        return convertToArrayList(DAOFactory.getActorDAO().index());
    }

    public ArrayList<Actor> index(BigInteger playId) {
        return convertToArrayList(DAOFactory.getActorDAO().index(playId));
    }

    @Override
    public Actor show(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException("Wrong key type");
        }
        return DAOFactory.getActorDAO().show(key);
    }

    @Override
    public void store(Actor actor) {
        DAOFactory.getActorDAO().store(actor);
    }

    @Override
    public void update(Actor actor) {
        DAOFactory.getActorDAO().update(actor);
    }

    @Override
    public void destroy(Actor actor) {
        DAOFactory.getActorDAO().destroy(actor);
    }

    public <T> ArrayList<Actor> convertToArrayList(List<T> actors) {
        return actors.stream()
                .filter(object -> object instanceof Actor)
                .map(object -> (Actor) object)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
