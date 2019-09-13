package com.cursor.tripplanner.service;

import com.cursor.tripplanner.model.Trip;

import java.util.List;

public interface TripService {

    List<Trip> findAllByUserId(Long userId);

    void addTrip (Trip trip);

    void deleteTrip(Long Id);

    void editTrip(Long oldTripId, Trip newTrip);

    Trip addPlaceToTrip (Long userId, Long tripId, Long placeId);

    Trip removePlaceFromTrip (Long userId, Long tripId, Long placeId);

    Trip shareTripWhitOtherUser(Long UserId, Long tripId);

}
