package rest;

import entity.Club;
import entity.Event;
import facade.ClubFacade;
import facade.EventFacade;
import facade.ParticipationFacade;
import entity.Participation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Stateless
@Path("/participation")
@Api("participation")
public class ParticipationResource {
    @Inject
    private ParticipationFacade participationFacade;

    @Inject
    private ClubFacade clubFacade;

    @Inject
    private EventFacade eventFacade;

    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes("application/json")
    @ApiOperation("erstellt eine Participation; mit RepresentativeId, LocationId und ClubId")
    public Response create(Participation participation){
        Club club = clubFacade.findById(participation.getClubId());
        Event event = eventFacade.findById(participation.getEventId());

        participation.setClub(club);
        participation.setEvent(event);

        em.persist(participation);

        return Response.created(
                UriBuilder.fromResource(ParticipationResource.class)
                        .path(String.valueOf(participation.getId())).build()).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @ApiOperation("löscht eine Participation")
    public Response deleteById(@PathParam("id") Long id) {
        Participation entity = em.find(Participation.class, id);
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        em.remove(entity);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    @ApiOperation("suche eine Participation anhand der id")
    public Response findById(@PathParam("id") Long id) {

        Participation participation = em.find(Participation.class, id);

        if (participation == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("reason", "[Participation] with id = " + id + " not found")
                    .build();
        }
        return Response.ok(participation).build();
    }

    @GET
    @Produces("application/json")
    @ApiOperation("liefert alle Participations zurück")
    public List<Participation> findAll(){
        return participationFacade.findAll();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation("ändern eine Participation (die Id der zu ändernden Participation muss separat mitgegeben werden")
    public Response update(@PathParam("id") Long id, Participation entity) {
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (!id.equals(entity.getId())) {
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        }
        if (em.find(Participation.class, id) == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        try {
            entity = em.merge(entity);
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(e.getEntity()).build();
        }

        return Response.noContent().build();
    }
}
