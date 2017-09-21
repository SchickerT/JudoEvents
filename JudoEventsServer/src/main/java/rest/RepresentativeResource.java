package rest;

import entity.Club;
import entity.Participation;
import facade.ClubFacade;
import facade.RepresentativeFacade;
import entity.Representative;
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
@Path("/representative")
@Api("representative")
public class RepresentativeResource {
    @Inject
    private RepresentativeFacade representativeFacade;

    @Inject
    private ClubFacade clubFacade;

    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes("application/json")
    @ApiOperation("erstellt einen Representative; mit der ClubId")
    public Response create(Participation representative){
        Club club = null;


        representative.setClub(club);

        em.persist(representative);

        return Response.created(
                UriBuilder.fromResource(RepresentativeResource.class)
                        .path(String.valueOf(representative.getId())).build()).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @ApiOperation("löscht einen Representative")
    public Response deleteById(@PathParam("id") Long id) {
        Representative entity = em.find(Representative.class, id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(entity);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    @ApiOperation("suche einen Representative anhand der id")
    public Response findById(@PathParam("id") Long id) {

        Representative representative = em.find(Representative.class, id);

        if (representative == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .header("reason", "[Representative] with id = " + id + " not found")
                    .build();
        }
        return Response.ok(representative).build();
    }

    @GET
    @Produces("application/json")
    @ApiOperation("liefert alle Representatives zurück")
    public List<Representative> findAll(){
        return representativeFacade.findAll();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation("ändern einen Representative (die Id der zu ändernden Representative muss separat mitgegeben werden")
    public Response update(@PathParam("id") Long id, Representative entity) {
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (!id.equals(entity.getId())) {
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        }
        if (em.find(Representative.class, id) == null) {
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

