package com.cursor.tripplanner.controller;

import com.cursor.tripplanner.model.Trip;
import com.cursor.tripplanner.model.User;
import com.cursor.tripplanner.service.TripPlannerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    private final TripPlannerImpl tripPlannerImpl;

    @Autowired
    public TripController(TripPlannerImpl tripPlannerImpl) {
        this.tripPlannerImpl = tripPlannerImpl;
    }

    @ResponseBody
    @GetMapping("/showTripsByUser")
    public ResponseEntity<List<Trip>> showTripsByUser(@PathVariable User user) {
        tripPlannerImpl.showTripsByUser(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/addTrip")
    public ResponseEntity addTrip(@RequestBody Trip trip) {
        tripPlannerImpl.addTrip(trip);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/deleteTrip/{id}")
    public ResponseEntity deleteTrip(@PathVariable("id") long tripId) {
        tripPlannerImpl.deleteTrip(tripId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/editTrip/{id}")
    public ResponseEntity editTrip(@PathVariable("id") Long oldTripId, @RequestBody Trip newTrip) {
        tripPlannerImpl.editTrip(oldTripId, newTrip);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
