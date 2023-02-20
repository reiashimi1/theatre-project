package com.theatreproject.rest.play;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.theatreproject.controllers.ActorControllerImpl;
import com.theatreproject.models.Actor;
import com.theatreproject.models.Play;
import com.theatreproject.models.Show;
import com.theatreproject.utils.GsonUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PlaySerializer implements JsonSerializer<Play> {
    @Override
    public JsonElement serialize(Play play, Type type,
                                 JsonSerializationContext context) {
        JsonObject showItem = new JsonObject();
        try {
            showItem.addProperty("id", play.getPlayid());
            showItem.addProperty("title", play.getTitle());
            showItem.addProperty("writer", play.getWriter());
            showItem.addProperty("director", play.getDirector());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return showItem;
    }
}