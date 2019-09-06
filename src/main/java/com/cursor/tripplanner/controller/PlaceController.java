package com.cursor.tripplanner.controller;

import com.cursor.tripplanner.model.Comment;
import com.cursor.tripplanner.model.Place;
import com.cursor.tripplanner.model.Rate;
import com.cursor.tripplanner.model.Trip;
import com.cursor.tripplanner.service.TripPlannerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PlaceController {

    private final TripPlannerImpl tripPlannerImpl;

    @Autowired
    public PlaceController(TripPlannerImpl tripPlannerImpl) {
        this.tripPlannerImpl = tripPlannerImpl;
    }

    @ResponseBody
    @GetMapping("/showAllPlaces")
    public ResponseEntity<List<Place>> showAllPlaces() {
        tripPlannerImpl.showAllPlaces();
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @GetMapping("/showPlacesByCountry")
    public ResponseEntity<List<Trip>> showPlacesByCountry(@PathVariable String country) {
        tripPlannerImpl.showPlacesByCountry(country);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @GetMapping("/showPlacesByTrip")
    public ResponseEntity<List<Trip>> showPlacesByTrip(@PathVariable Trip trip) {
        tripPlannerImpl.showPlacesByTrip(trip);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/commentPlace")
    public ResponseEntity commentPlace(@RequestBody Comment comment) {
        tripPlannerImpl.commentPlace(comment);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/ratePlace")
    public ResponseEntity ratePlace(@RequestBody Rate rate) {
        tripPlannerImpl.ratePlace(rate);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
