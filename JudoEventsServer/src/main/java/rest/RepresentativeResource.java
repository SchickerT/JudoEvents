package rest;

import business.RepresentativeFacade;
import entity.Representative;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Path("Representative")
public class RepresentativeResource {
    @Inject
    private RepresentativeFacade representativeFacade;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Representative find(@PathParam("id") long id){
        return representativeFacade.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Representative> findAll(){
        return representativeFacade.findAll();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id){
        representativeFacade.delete(id);
    }

    @POST
    public void save(Representative representative){
        representativeFacade.save(representative);
    }
}
