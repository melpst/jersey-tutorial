package com.ddth.rest;

import com.ddth.connection.ConnectionManager;
import com.ddth.model.Track;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;

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
        track.setSinger(input.getSinger());
        track.setTitle(input.getTitle());

        Connection connection = null;
        boolean isConnected = false;

        try{
            connection = ConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                ConnectionManager.closeConnection(connection);
            }
        }

        String result = "Track saved : " + track;

        return Response.status(201).entity(result).build();
    }
}


