package rest;

import business.EventFacade;
import entity.Event;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Path("event")
public class EventResource {
    @Inject
    private EventFacade eventFacade;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Event find(@PathParam("id") long id){
        return eventFacade.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> findAll(){
        return eventFacade.findAll();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id){
        eventFacade.delete(id);
    }

    @POST
    public void save(Event event){
        eventFacade.save(event);
    }
}
