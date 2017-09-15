package rest;

import business.LocationFacade;
import entity.Location;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Path("location")
public class LocationResource {
    @Inject
    private LocationFacade locationFacade;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Location find(@PathParam("id") long id){
        return locationFacade.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Location> findAll(){
        return locationFacade.findAll();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id){
        locationFacade.delete(id);
    }

    @POST
    public void save(Location location){
        locationFacade.save(location);
    }
}
