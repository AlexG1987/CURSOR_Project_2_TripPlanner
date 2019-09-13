package com.cursor.tripplanner.service;

import com.cursor.tripplanner.model.Comment;
import com.cursor.tripplanner.model.Place;
import com.cursor.tripplanner.model.Rate;

import java.util.List;

public interface PlaceService {

    List<Place> showAllPlaces();

    List<Place> showPlacesByCountry(String country);

    List<Place> showPlacesByTrip(Long tripId);

    void addPlace(Place place);

    void commentPlace(Comment comment);

    void ratePlace(Rate rate);

}
