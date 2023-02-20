package com.theatreproject.rest.show;

import com.google.gson.*;
import com.theatreproject.models.Play;
import com.theatreproject.models.Show;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public class ShowDeserializer implements JsonDeserializer<Show> {
    @Override
    public Show deserialize(JsonElement jsonElement, Type type,
                            JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject json = (JsonObject) jsonElement;
        Show show = new Show();

        try {
            show.setShowdate(new SimpleDateFormat().parse(json.get("showDate").getAsString()));
            Play play = new Play();
            play.setTitle(json.get("playTitle").getAsString());
            play.setWriter(json.get("playWriter").getAsString());
            play.setDirector(json.get("playDirector").getAsString());
            show.setPlay(play);
            show.setSeatsoccupied(json.get("occupiedSeats").getAsBigInteger());
            show.getHall().setTotalseats(json.get("allSeats").getAsBigInteger());
            return show;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}