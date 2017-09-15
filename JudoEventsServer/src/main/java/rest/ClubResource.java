package rest;

import business.ClubFacade;
import entity.Club;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Path("club")
public class ClubResource {
    @Inject
    private ClubFacade clubFacade;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Club find(@PathParam("id") long id){
        return clubFacade.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Club> findAll(){
        return clubFacade.findAll();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id){
        clubFacade.delete(id);
    }

    @POST
    public void save(Club club){
        clubFacade.save(club);
    }
}
