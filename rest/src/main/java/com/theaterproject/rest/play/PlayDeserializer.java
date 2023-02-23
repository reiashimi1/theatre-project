package com.theaterproject.rest.play;

import com.google.gson.*;
import com.theatreproject.models.Play;

import java.lang.reflect.Type;

public class PlayDeserializer implements JsonDeserializer<Play> {
    @Override
    public Play deserialize(JsonElement jsonElement, Type type,
                            JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject json = (JsonObject) jsonElement;
        Play play = new Play();

        try {
            play.setPlayid(json.get("id").getAsBigInteger());
            play.setTitle(json.get("title").getAsString());
            play.setWriter(json.get("writer").getAsString());
            play.setDirector(json.get("director").getAsString());
            return play;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}