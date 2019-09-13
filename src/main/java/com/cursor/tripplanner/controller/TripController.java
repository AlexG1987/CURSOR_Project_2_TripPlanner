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
@RequestMapping("trips")
public class TripController {

    private final TripServiceImpl tripServiceImpl;

    @ResponseBody
    @GetMapping("/showTripsByUser/{id}")
    public ResponseEntity<List<Trip>> showTripsByUser(@PathVariable(name = "id") Long userId) {
        tripServiceImpl.findAllByUserId(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/addTrip")
    public ResponseEntity addTrip(@RequestBody Trip trip) {
        tripServiceImpl.addTrip(trip);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/deleteTrip/{id}")
    public ResponseEntity deleteTrip(@PathVariable(name = "id") Long tripId) {
        tripServiceImpl.deleteTrip(tripId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/editTrip/{id}")
    public ResponseEntity editTrip(@PathVariable(name = "id") Long oldTripId, @RequestBody Trip newTrip) {
        tripServiceImpl.editTrip(oldTripId, newTrip);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @PostMapping("/addPlaceToTrip/user/{userId}/trip/{tripId}/place/{placeId}")
    public ResponseEntity addPlaceToTrip(@PathVariable(name = "userId") Long userId,
                                         @PathVariable(name = "tripId") Long tripId,
                                         @PathVariable(name = "placeId") Long placeId) {
        tripServiceImpl.addPlaceToTrip(userId, tripId, placeId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @DeleteMapping("deletePlaceFromTrip/user/{userId}/trip/{tripId}/place/{placeId}")
    public ResponseEntity deletePlaceFromTrip(
            @PathVariable(name = "userId") Long userId,
            @PathVariable(name = "tripId") Long tripId,
            @PathVariable(name = "placeId") Long placeId) {
        tripServiceImpl.removePlaceFromTrip(userId, tripId, placeId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/shareTripWhitOtherUser/user/{userId}/trip/{tripId}")
    public ResponseEntity shareTripWhitOtherUser(@PathVariable(name = "userId") Long userId,
                                                 @PathVariable(name = "tripId") Long tripId) {
        tripServiceImpl.shareTripWhitOtherUser(userId, tripId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
