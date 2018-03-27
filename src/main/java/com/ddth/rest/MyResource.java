package com.ddth.rest;

import com.ddth.model.Track;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    static Track track = new Track();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {

        return track;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track input) {

        String result = "Track saved : " + track;
        track.setSinger(input.getSinger());
        track.setTitle(input.getTitle());
        return Response.status(201).entity(result).build();

    }
}


