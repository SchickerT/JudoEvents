package rest;

import business.ParticipationFacade;
import entity.Participation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Path("participation")
public class ParticipationResource {
    @Inject
    private ParticipationFacade participationFacade;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Participation find(@PathParam("id") long id){
        return participationFacade.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Participation> findAll(){
        return participationFacade.findAll();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id){
        participationFacade.delete(id);
    }

    @POST
    public void save(Participation participation){
        participationFacade.save(participation);
    }
}
