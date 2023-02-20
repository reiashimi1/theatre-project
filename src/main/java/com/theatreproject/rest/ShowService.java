package com.theatreproject.rest;

import com.theatreproject.controllers.CustomerControllerImpl;
import com.theatreproject.controllers.ShowControllerImpl;
import com.google.gson.JsonObject;
import com.theatreproject.models.Customer;
import com.theatreproject.models.Show;
import com.theatreproject.utils.GsonUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("shows")
public class ShowService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShow(@PathParam("id") String id,
                            @HeaderParam("username") String username, @HeaderParam("password") String password) {
        Customer customer = CustomerControllerImpl.getInstance().authenticate(username, password);
        if (customer == null) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Not correct credentials")
                    .build();

        }
        return Response.status(Response.Status.OK)
                .entity(getJsonObjectWithTotalRecords(ShowControllerImpl.getInstance().show(id)))
                .build();    }

    private JsonObject getJsonObjectWithTotalRecords(Show show) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.add("show", GsonUtil.getShowSerializerGson().toJsonTree(show));
        return jsonObject;
    }
}