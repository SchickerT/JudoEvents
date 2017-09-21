package entity;

import entity.enums.TypeOfEvent;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by marcelpautz on 17.07.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name="Event.findAll",
                query = "SELECT e FROM Event e"
        )
})
@XmlRootElement
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private TypeOfEvent typeOfEvent;

    private String name;
    private String discription;
    private double entryFee;
    private String rewards;
    private String ageAndWeight;

    @Lob
    private byte[] picture;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @ManyToOne(cascade = CascadeType.ALL)
    private Club club;

    @ManyToOne(cascade = CascadeType.ALL)
    private Representative representative;

    public Event() {
    }

    public Event(LocalDate startDate, LocalDate endDate, TypeOfEvent typeOfEvent, String name, String discription, double entryFee, String rewards, String ageAndWeight, Location location, Club club, Representative representative) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeOfEvent = typeOfEvent;
        this.name = name;
        this.discription = discription;
        this.entryFee = entryFee;
        this.rewards = rewards;
        this.ageAndWeight = ageAndWeight;
        this.location = location;
        this.club = club;
        this.representative = representative;
    }

    //region GETTER AND SETTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public TypeOfEvent getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(TypeOfEvent typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public String getAgeAndWeight() {
        return ageAndWeight;
    }

    public void setAgeAndWeight(String ageAndWeight) {
        this.ageAndWeight = ageAndWeight;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Representative getRepresentative() {
        return representative;
    }

    public void setRepresentative(Representative representative) {
        this.representative = representative;
    }

    //endregion
}
