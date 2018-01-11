package rest;

import entity.Club;
import entity.Location;
import entity.Representative;
import facade.ClubFacade;
import facade.EventFacade;
import entity.Event;
import facade.LocationFacade;
import facade.RepresentativeFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Stateless
@Path("/event")
@Api("event")
public class EventResource {
    @Inject
    private EventFacade eventFacade;

    @Inject
    private LocationFacade locationFacade;

    @Inject
    private ClubFacade clubFacade;

    @Inject
    private RepresentativeFacade representativeFacade;

    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes("application/json")
    @ApiOperation("erstellt eine Event; mit RepresentativeId, LocationId und ClubId")
    public Response create(Event event){
        Representative representative = event.getRepresentative();
        Location location = event.getLocation();
        Club club = clubFacade.findById(event.getClub().getId());

        if(representative.getFirstName().isEmpty())
            representative = club.getRepresentative();
        if(location.getCity().isEmpty())
            location=club.getLocation();

        event.setClub(club);
        event.setRepresentative(representative);
        event.setLocation(location);
        em.persist(event);

        return Response.created(
                UriBuilder.fromResource(EventResource.class)
                        .path(String.valueOf(event.getId())).build()).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @ApiOperation("löscht ein Event")
    public Response deleteById(@PathParam("id") Long id) {
        Event entity = em.find(Event.class, id);
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        em.remove(entity);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    @ApiOperation("suche ein Event anhand der id")
    public Response findById(@PathParam("id") Long id) {

        Event club = em.find(Event.class, id);
        return Response.ok(club).build();
    }

    @GET
    @Produces("application/json")
    @ApiOperation("liefert alle Events zurück")
    public List<Event> findAll(){
        List<Event> events = eventFacade.findAll();
        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.getStartDate().compareTo(o2.getStartDate());
            }
        });
        return events;
    }

    @GET
    @Path("/tournaments")
    @Produces("application/json")
    @ApiOperation("liefert alle Turniere zurück")
    public List<Event> findAllTournaments(){
        return eventFacade.findAllTournaments();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation("ändern ein Event (die Id des zu ändernden Events muss separat mitgegeben werden")
    public Response update(@PathParam("id") Long id, Event entity) {
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (!id.equals(entity.getId())) {
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        }
        if (em.find(Event.class, id) == null) {
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
