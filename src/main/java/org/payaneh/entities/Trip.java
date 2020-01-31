package org.payaneh.entities;

import org.payaneh.config.PersistentEntity;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class Trip extends PersistentEntity<Integer> {
    private String destination,origin;
    private String tripDate;
    private String tripTime;

    public Trip() {
    }

    public Trip(String destination, String origin, String tripDate, String tripTime) {
        this.destination = destination;
        this.origin = origin;
        this.tripDate = tripDate;
        this.tripTime = tripTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public String getTripTime() {
        return tripTime;
    }

    public void setTripTime(String tripTime) {
        this.tripTime = tripTime;
    }
}
