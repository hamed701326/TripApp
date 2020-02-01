package org.payaneh.repositories;

import org.junit.jupiter.api.Test;
import org.payaneh.entities.Trip;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripRepositoryTest {
    private TripRepository tripRepo=TripRepository.getTripRepo();

    @Test
    void findAll() {
        List<Trip> trips=tripRepo.findAll("esfehan","tehran","1/31/2020");
        trips.forEach(trip -> System.out.println(trip.getId()));
    }
    @Test
    void savelist(){

        List<Trip> trips= Arrays
                .asList(
                new Trip(
                "tehran",
                "esfehan",
                "1/31/2020",
                "8:40"),
                new Trip(
                "esfehan",
                "tehran",
                "1/31/2020",
                "8:40"));
        tripRepo.save(trips);
    }
}