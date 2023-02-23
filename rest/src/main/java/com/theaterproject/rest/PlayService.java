package com.theaterproject.rest;

import com.google.gson.JsonObject;
import com.theatreproject.controllers.PlayControllerImpl;
import com.theatreproject.controllers.UserControllerImpl;
import com.theatreproject.models.Play;
import com.theatreproject.models.User;
import com.theatreproject.utils.GsonUtil;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/plays")
public class PlayService {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlays(@HeaderParam("username") String username, @HeaderParam("password") String password) {
        User user = UserControllerImpl.getInstance().authenticate(username, password);
        if (user == null) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Not correct credentials")
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(getJsonObjectWithTotalRecords(PlayControllerImpl.getInstance().index()))
                .build();
    }

    private JsonObject getJsonObjectWithTotalRecords(List<Play> plays) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.add("plays", GsonUtil.getPlaysSerializerGson().toJsonTree(plays));
        return jsonObject;
    }
}