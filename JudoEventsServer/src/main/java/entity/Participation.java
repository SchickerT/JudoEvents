package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by marcelpautz on 17.07.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name="Participation.findAll",
                query = "SELECT p FROM Participation p"
        )
})
@XmlRootElement
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private int numberOfStarters;

    private String starters;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    private Club club;

    private long clubId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    private Event event;

    private long eventId;

    public Participation() {
    }

    public Participation(int numberOfStarters, String starters, Club club, Event event) {
        this.numberOfStarters = numberOfStarters;
        this.starters = starters;
        this.club = club;
        this.event = event;
        this.clubId = club.getId();
        this.eventId = event.getId();
    }

    //region GETTER AND SETTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfStarters() {
        return numberOfStarters;
    }

    public void setNumberOfStarters(int numberOfStarters) {
        this.numberOfStarters = numberOfStarters;
    }

    public String getStarters() {
        return starters;
    }

    public void setStarters(String starters) {
        this.starters = starters;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public long getClubId() {
        return clubId;
    }

    public void setClubId(long clubId) {
        this.clubId = clubId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    //endregion
}
