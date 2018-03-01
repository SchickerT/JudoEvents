package rest;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import entity.Club;
import entity.Location;
import entity.Representative;
import entity.enums.TypeOfEvent;
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
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.StringReader;
import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;
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
    public Response create(String eventString){
        JsonReader reader = Json.createReader(new StringReader(eventString));
        JsonObject jsonObject = reader.readObject();

        Event event = new Event();

        Instant startDateInst = Instant.parse(jsonObject.getString("startDate"));
        LocalDate startDate = LocalDateTime.ofInstant(startDateInst, ZoneId.of(ZoneOffset.UTC.getId())).toLocalDate();

        Instant endDateInst = Instant.parse(jsonObject.getString("endDate"));
        LocalDate endDate = LocalDateTime.ofInstant(endDateInst, ZoneId.of(ZoneOffset.UTC.getId())).toLocalDate();

        event.setStartDate(startDate);
        event.setEndDate(endDate);
        event.setName(jsonObject.getString("name"));
        event.setDiscription(jsonObject.getString("discription"));
        event.setEntryFee(Double.parseDouble(jsonObject.getString("entryFee")));
        event.setRewards(jsonObject.getString("rewards"));
        event.setAgeAndWeight(jsonObject.getString("ageAndWeight"));
        event.setEventPicture(jsonObject.getString("eventPicture").getBytes());

        Location location = new Location();
        JsonObject locOb = jsonObject.getJsonObject("location");

        location.setCity(locOb.getString("city"));
        location.setZipCode(locOb.getString("zipCode"));
        location.setStreet(locOb.getString("street"));
        location.setFederalState(locOb.getString("federalState"));
        location.setCountry(locOb.getString("country"));
        location.setLongitude((locOb.getJsonNumber("longitude").doubleValue()));
        location.setLatitude((locOb.getJsonNumber("latitude").doubleValue()));
        location.setCountryCode(locOb.getString("countryCode"));

        event.setLocation(location);

        Representative representative = new Representative();
        JsonObject repOb = jsonObject.getJsonObject("representative");

        representative.setFirstName(repOb.getString("firstName"));
        representative.setLastName(repOb.getString("lastName"));
        representative.setEmail(repOb.getString("email"));
        representative.setPhoneNumber(repOb.getString("phoneNumber"));
        representative.setRepresentativePicture(repOb.getString("representativePicture").getBytes());

        event.setRepresentative(representative);

        Club club = clubFacade.findById(1);

        System.out.println(event.getStartDate());
        System.out.println(event.getEndDate());
        event.setTypeOfEvent(TypeOfEvent.Turnament);
        event.setClub(club);

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
    @Path("/tournaments/{SDate}/{EDate}/{Count}")
    @Produces("application/json")
    @ApiOperation("liefert alle Turniere zurück")
    public List<Event> findAllTournaments(@PathParam("SDate") String sDate,@PathParam("EDate") String eDate,@PathParam("Count") String count){
        if(count.equals("-1")&&!sDate.equals("-1")) {
            Instant startDateInst = Instant.parse(sDate);
            LocalDate startDate = LocalDateTime.ofInstant(startDateInst, ZoneId.of(ZoneOffset.UTC.getId())).toLocalDate();
            Instant endDateInst = Instant.parse(eDate);
            LocalDate endDate = LocalDateTime.ofInstant(endDateInst, ZoneId.of(ZoneOffset.UTC.getId())).toLocalDate();

            return eventFacade.findAllTournamentsDate(startDate,endDate);
        } else{
            if(!count.equals("-1")&&sDate.equals("-1")){
                return eventFacade.findAllTournamentCountry(count);
            }else {
                if(!count.equals("-1")&&!sDate.equals("-1")){
                    Instant startDateInst = Instant.parse(sDate);
                    LocalDate startDate = LocalDateTime.ofInstant(startDateInst, ZoneId.of(ZoneOffset.UTC.getId())).toLocalDate();
                    Instant endDateInst = Instant.parse(eDate);
                    LocalDate endDate = LocalDateTime.ofInstant(endDateInst, ZoneId.of(ZoneOffset.UTC.getId())).toLocalDate();

                    return eventFacade.findAllTounamentsCountryDate(startDate,endDate,count);
                }
                else{
                    return eventFacade.findAllTournaments();
                }
            }
        }
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
