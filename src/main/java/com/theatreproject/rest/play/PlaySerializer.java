package com.theatreproject.rest.play;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.theatreproject.models.Play;
import com.theatreproject.utils.GsonUtil;

import java.lang.reflect.Type;

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
            showItem.add("shows", GsonUtil.getShowSerializerGson().toJsonTree(play.getShows()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return showItem;
    }
}