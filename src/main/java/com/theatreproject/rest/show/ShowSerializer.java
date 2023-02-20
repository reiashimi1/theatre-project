package com.theatreproject.rest.show;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.theatreproject.controllers.ActorControllerImpl;
import com.theatreproject.models.Actor;
import com.theatreproject.models.Show;
import com.theatreproject.utils.GsonUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ShowSerializer implements JsonSerializer<Show> {
    @Override
    public JsonElement serialize(Show show, Type type,
                                 JsonSerializationContext context) {
        JsonObject showItem = new JsonObject();
        try {
            showItem.addProperty("showId", show.getShowid());
            showItem.addProperty("showDate", show.getShowdate().toString());
            showItem.addProperty("playTitle", show.getPlay().getTitle());
            showItem.addProperty("playWriter", show.getPlay().getWriter());
            showItem.addProperty("playDirector", show.getPlay().getDirector());
            showItem.add("actors", GsonUtil.getActorPlaySerializerGson().toJsonTree(getActors()));
            showItem.addProperty("allSeats", show.getHall().getTotalseats());
            showItem.addProperty("occupiedSeats", show.getSeatsoccupied());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return showItem;
    }

    private List<Actor> getActors() {
        List<Actor> actors = ActorControllerImpl.getInstance().index();
        return actors == null ? new ArrayList<>() : actors;
    }

}