package org.payaneh.entities;

import org.payaneh.config.PersistentEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket extends PersistentEntity<Integer> {
    private String name,sex;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Trip trip;

    public Ticket() {
    }

    public Ticket(String name, String sex, User user, Trip trip) {
        this.name = name;
        this.sex = sex;
        this.user = user;
        this.trip = trip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
