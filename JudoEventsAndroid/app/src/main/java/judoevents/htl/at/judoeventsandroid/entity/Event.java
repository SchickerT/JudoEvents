package judoevents.htl.at.judoeventsandroid.entity;

import android.graphics.Bitmap;

import java.sql.Blob;
import java.util.Date;

/**
 * Created by User on 20.11.2017.
 */

public class Event {

    private long id;
    private String age_weigth;
    private String description;
    private Date enddate;
    private Float entryFee;
    private String eventName;
    private Bitmap picture;
    private String rewards;
    private Date startDate;
    private String typeOfEvent;
    private Integer clubId;
    private Integer LocationId;
    private Integer Representative;

    //region Getter + Setter
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge_weigth() {
        return age_weigth;
    }

    public void setAge_weigth(String age_weigth) {
        this.age_weigth = age_weigth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Float getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(Float entryFee) {
        this.entryFee = entryFee;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getLocationId() {
        return LocationId;
    }

    public void setLocationId(Integer locationId) {
        LocationId = locationId;
    }

    public Integer getRepresentative() {
        return Representative;
    }

    public void setRepresentative(Integer representative) {
        Representative = representative;
    }
    //endregion


    public Event(String eventName, Bitmap picture) {
        this.eventName = eventName;
        this.picture = picture;
    }

    public Event () {


    }

}
