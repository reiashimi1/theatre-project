package com.theatreproject.rest.actors;

import com.google.gson.*;
import com.theatreproject.models.ActorPlay;

import java.lang.reflect.Type;

public class ActorDeserializer implements JsonDeserializer<ActorPlay> {

    @Override
    public ActorPlay deserialize(JsonElement jsonElement, Type type,
                                 JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject json = (JsonObject) jsonElement;
        ActorPlay actorPlay = new ActorPlay();

        try {
            actorPlay.setActorid(json.get("actorId").getAsBigInteger());
            actorPlay.getActor().setActorname(json.get("actorName").getAsString());

            return actorPlay;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
