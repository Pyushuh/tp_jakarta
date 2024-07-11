package com.example.demo1;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/jakarta")
public class JakartaResource {

    // Simulated list of IDs
    public List<Integer> idList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    // GET method
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "GET request received!";
    }

    // GET method
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMessageId(@PathParam("id") int id) {
        if (idList.contains(id)) {
            return Response.ok("The id " + id + " exists, get ok").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("The id " + id + " does not exist, get failed")
                    .build();
        }
    }

    // POST method
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postMessage() {
        return "POST request received!";
    }

    // PUT method
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String putMessage() {
        return "PUT request received!";
    }

    // DELETE method with ID parameter
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteMessage(@PathParam("id") int id) {
        if (idList.contains(id)) {
            idList.remove(Integer.valueOf(id));
            return Response.ok("The id " + id + " exists, delete ok").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("The id " + id + " does not exist, delete failed")
                    .build();
        }
    }
}
