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
@RequestMapping("place")
public class PlaceController {

    private final PlaceServiceImpl placeServiceImpl;

    @ResponseBody
    @GetMapping("/all")
    public List<Place> getAllPlaces() {
        return placeServiceImpl.getAllPlaces();
    }

    @ResponseBody
    @GetMapping("/country")
    public List<Place> getPlacesByCountry(@PathVariable String country) {
        return placeServiceImpl.getPlacesByCountry(country);
    }

    @ResponseBody
    @GetMapping("/{tripId}")
    public List<Place> showPlacesByTrip(@PathVariable(name = "tripId") Long tripId) {
        return placeServiceImpl.getPlacesByTrip(tripId);
    }

    @PutMapping("/comment")
    public ResponseEntity commentPlace(@RequestBody Comment comment) {
        placeServiceImpl.commentPlace(comment);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/rate")
    public ResponseEntity ratePlace(@RequestBody Rate rate) {
        placeServiceImpl.ratePlace(rate);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/add")
    public ResponseEntity addPlace(@RequestBody Place place) {
        placeServiceImpl.addPlace(place);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
