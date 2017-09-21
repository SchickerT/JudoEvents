package rest;

import entity.Location;
import entity.Representative;
import facade.ClubFacade;
import entity.Club;
import facade.EventFacade;
import facade.LocationFacade;
import facade.RepresentativeFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
@Path("/club")
@Api("club")
public class ClubResource {
    @Inject
    ClubFacade clubFacade;

    @Inject
    EventFacade eventFacade;

    @Inject
    RepresentativeFacade representativeFacade;

    @Inject
    LocationFacade locationFacade;

    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes("application/json")
    @ApiOperation("erstellt einen Club; mit RepresentativeId und LocationId")
    public Response create(Club club){
        Representative representative = club.getRepresentative();
        Location location = club.getLocation();

        club.setRepresentative(representative);
        club.setLocation(location);

        em.persist(club);

        return Response.created(
                UriBuilder.fromResource(ClubResource.class)
                        .path(String.valueOf(club.getId())).build()).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @ApiOperation("löscht einen Club")
    public Response deleteById(@PathParam("id") Long id) {
        Club entity = em.find(Club.class, id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(entity);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    @ApiOperation("suchen einen Club anhand der id")
    public Response findById(@PathParam("id") Long id) {

        Club club = em.find(Club.class, id);

        if (club == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .header("reason", "[Club] with id = " + id + " not found")
                    .build();
        }
        return Response.ok(club).build();
    }

    @GET
    @Produces("application/json")
    @ApiOperation("suchen aller Clubs mit Startwert und max. Anzahl von zurückgegebenen Buchungen")
    public List<Club> findAll(
            @ApiParam("Startwert - dieser Parameter ist wahlweise") @QueryParam("start") Integer startPosition,
            @ApiParam("Anzahl der zurückgegebenen Buchungen - dieser Parameter ist wahlweise") @QueryParam("max") Integer maxResult) {

        return clubFacade.findAll(startPosition, maxResult);
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation("ändern einen Club (die Id des zu ändernden Clubs muss separat mitgegeben werden")
    public Response update(@PathParam("id") Long id, Club entity) {
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (!id.equals(entity.getId())) {
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        }
        if (em.find(Club.class, id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
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
