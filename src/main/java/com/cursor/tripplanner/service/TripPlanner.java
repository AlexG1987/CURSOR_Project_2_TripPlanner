package com.cursor.tripplanner.service;

import com.cursor.tripplanner.model.*;

import java.util.List;

public interface TripPlanner {

    List<Place> showAllPlaces();

    List<Place> showPlacesByCountry(String country);

    List<Place> showPlacesByTrip(Trip trip);

    List<Trip> showTripsByUser(User user);

    void addTrip(Trip trip);

    void deleteTrip(long Id);

    void editTrip(Long oldTripId, Trip newTrip);

    void commentPlace(Comment comment);

    void ratePlace(Rate rate);

    void addUser(User user);

    void deleteUser(long Id);

    void editUser(Long oldUserId, User newUser);

    Trip  shareTripWhitOtherUser(Long UserId, Long tripId);

}
