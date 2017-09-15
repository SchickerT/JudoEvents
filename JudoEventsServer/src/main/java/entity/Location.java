package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by marcelpautz on 17.07.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name="Location.findAll",
                query = "SELECT l FROM Location l"
        )
})
@XmlRootElement
@Table(name = "W_LOCATION")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String zipCode;
    private String city;
    private String street;
    private String federalState;
    private String country;

    @OneToMany
    private List<Club> clubs;

    @OneToMany
    private List<Event> events;

    public Location(String zipCode, String city, String street, String federalState, String country) {
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.federalState = federalState;
        this.country = country;
    }

    public Location() {
    }

    //region GETTER AND SETTTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFederalState() {
        return federalState;
    }

    public void setFederalState(String federalState) {
        this.federalState = federalState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    //endregion
}
