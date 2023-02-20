package com.theatreproject.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.theatreproject.models.ActorPlay;
import com.theatreproject.models.Play;
import com.theatreproject.models.Show;
import com.theatreproject.rest.actors.ActorDeserializer;
import com.theatreproject.rest.actors.ActorSerializer;
import com.theatreproject.rest.play.PlaySerializer;
import com.theatreproject.rest.show.ShowSerializer;

public class GsonUtil {

    public static Gson getActorPlaySerializerGson() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ActorPlay.class, new ActorSerializer());
        gsonBuilder.setPrettyPrinting();
        return gsonBuilder.create();
    }

    public static Gson getPlaysSerializerGson() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Play.class, new PlaySerializer());
        gsonBuilder.setPrettyPrinting();
        return gsonBuilder.create();
    }

    public static Gson getShowSerializerGson() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Show.class, new ShowSerializer());
        gsonBuilder.setPrettyPrinting();
        return gsonBuilder.create();
    }

    public static Gson getActorPlayDeserializerGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ActorPlay.class, new ActorDeserializer());
        return gsonBuilder.create();
    }

//    public static Gson getRecordSerializerGson() {
//        final GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(Record.class, new RecordSerializer());
//        gsonBuilder.setPrettyPrinting();
//        return gsonBuilder.create();
//    }
}
