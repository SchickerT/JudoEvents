package rest;

import entity.Club;
import entity.Event;
import entity.Representative;
import facade.LocationFacade;
import entity.Location;
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
@Path("/location")
@Api("location")
public class LocationResource {
    @Inject
    private LocationFacade locationFacade;

    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes("application/json")
    @ApiOperation("erstellt eine Location")
    public Response create(Location location){
        em.persist(location);

        return Response.created(
                UriBuilder.fromResource(LocationResource.class)
                        .path(String.valueOf(location.getId())).build()).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @ApiOperation("löscht eine Location")
    public Response deleteById(@PathParam("id") Long id) {
        Location entity = em.find(Location.class, id);
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        em.remove(entity);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    @ApiOperation("suche eine Location anhand der id")
    public Response findById(@PathParam("id") Long id) {

        Location location = em.find(Location.class, id);

        if (location == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("reason", "[Location] with id = " + id + " not found")
                    .build();
        }
        return Response.ok(location).build();
    }

    @GET
    @Produces("application/json")
    @ApiOperation("liefert alle Locations zurück")
    public List<Location> findAll(){
        return locationFacade.findAll();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation("ändern eine Location (die Id der zu ändernden Location muss separat mitgegeben werden")
    public Response update(@PathParam("id") Long id, Location entity) {
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (!id.equals(entity.getId())) {
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        }
        if (em.find(Location.class, id) == null) {
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
