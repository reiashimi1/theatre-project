package com.theaterproject.rest.actors;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.theatreproject.models.ActorPlay;

import java.lang.reflect.Type;

public class ActorSerializer implements JsonSerializer<ActorPlay> {

    @Override
    public JsonElement serialize(ActorPlay actorPlay, Type type,
                                 JsonSerializationContext context) {
        JsonObject actorPlayItem = new JsonObject();
        try {
            actorPlayItem.addProperty("actorId", actorPlay.getActorid());
            actorPlayItem.addProperty("actorName", actorPlay.getActor().getActorname());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actorPlayItem;
    }
}
