package com.cursor.tripplanner.controller;

import com.cursor.tripplanner.model.Trip;
import com.cursor.tripplanner.service.TripServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("trip")
public class TripController {

    private final TripServiceImpl tripServiceImpl;

    @ResponseBody
    @GetMapping("/{userId}")
    public List<Trip> getTripsByUser(@PathVariable(name = "userId") Long userId) {
        return tripServiceImpl.findAllByUserId(userId);
    }

    @PostMapping("/")
    public ResponseEntity addTrip(@RequestBody Trip trip) {
        tripServiceImpl.addTrip(trip);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{tripId}")
    public ResponseEntity deleteTrip(@PathVariable(name = "tripId") Long tripId) {
        tripServiceImpl.deleteTrip(tripId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/{oldTripId}")
    public ResponseEntity editTrip(@PathVariable(name = "oldTripId") Long oldTripId, @RequestBody Trip newTrip) {
        tripServiceImpl.editTrip(oldTripId, newTrip);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @PostMapping("/place{tripId}{placeId}")
    public ResponseEntity addPlaceToTrip(@PathVariable(name = "tripId") Long tripId,
                                         @PathVariable(name = "placeId") Long placeId) {
        tripServiceImpl.addPlaceToTrip(tripId, placeId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @DeleteMapping("/place{userId}{tripId}{placeId}")
    public ResponseEntity deletePlaceFromTrip(
            @PathVariable(name = "userId") Long userId,
            @PathVariable(name = "tripId") Long tripId,
            @PathVariable(name = "placeId") Long placeId) {
        tripServiceImpl.removePlaceFromTrip(userId, tripId, placeId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/share{userId}{tripId}")
    public ResponseEntity shareTripWhitOtherUser(@PathVariable(name = "userId") Long userId,
                                                 @PathVariable(name = "tripId") Long tripId) {
        tripServiceImpl.shareTripWhitOtherUser(userId, tripId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
