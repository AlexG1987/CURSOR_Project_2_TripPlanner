package com.cursor.tripplanner.controller;

import com.cursor.tripplanner.model.Comment;
import com.cursor.tripplanner.model.Place;
import com.cursor.tripplanner.model.Rate;
import com.cursor.tripplanner.service.PlaceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("places")
public class PlaceController {

    private final PlaceServiceImpl placeServiceImpl;

    @ResponseBody
    @GetMapping("/showAllPlaces")
    public ResponseEntity<List<Place>> showAllPlaces() {
        placeServiceImpl.showAllPlaces();
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @GetMapping("/showPlacesByCountry")
    public ResponseEntity<List<Place>> showPlacesByCountry(@PathVariable String country) {
        placeServiceImpl.showPlacesByCountry(country);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @GetMapping("/showPlacesByTrip/{id}")
    public ResponseEntity<List<Place>> showPlacesByTrip(@PathVariable(name = "id") Long tripId) {
        placeServiceImpl.showPlacesByTrip(tripId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/commentPlace")
    public ResponseEntity commentPlace(@RequestBody Comment comment) {
        placeServiceImpl.commentPlace(comment);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/ratePlace")
    public ResponseEntity ratePlace(@RequestBody Rate rate) {
        placeServiceImpl.ratePlace(rate);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/addPlace")
    public ResponseEntity addPlace(@RequestBody Place place) {
        placeServiceImpl.addPlace(place);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
