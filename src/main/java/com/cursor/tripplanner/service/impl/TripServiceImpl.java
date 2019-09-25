package com.cursor.tripplanner.service.impl;

import com.cursor.tripplanner.exceptions.NotFoundException;
import com.cursor.tripplanner.model.Place;
import com.cursor.tripplanner.model.Trip;
import com.cursor.tripplanner.model.User;
import com.cursor.tripplanner.repo.PlaceRepo;
import com.cursor.tripplanner.repo.TripRepo;
import com.cursor.tripplanner.repo.UserRepo;
import com.cursor.tripplanner.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepo tripRepo;
    private final PlaceRepo placeRepo;
    private final UserRepo userRepo;

    @Override
    public List<Trip> findAllByUserId(Long userId) {
        return tripRepo.findAllByUserId(userId);
    }


    @Override
    public void addTrip(Trip trip) {
        tripRepo.save(trip);
    }

    @Override
    public void deleteTrip(Long Id) {
        tripRepo.deleteById(Id);
    }

    @Override
    public Trip editTrip(Long oldTripId, Trip newTrip) {
        if (tripRepo.existsById(oldTripId)) {
            tripRepo.deleteById(oldTripId);
            Trip trip = new Trip();
            trip.setId(oldTripId);
            trip.setUser(newTrip.getUser());
            trip.setTripDate(newTrip.getTripDate());
            trip.setTripName(newTrip.getTripName());
            trip.setTripUsers(newTrip.getTripUsers());
            trip.setTripPlaces(newTrip.getTripPlaces());
            return tripRepo.save(trip);
        }else{
            return tripRepo.save(newTrip);
        }
    }

    @Override
    public Trip addPlaceToTrip(Long tripId, Long placeId) {
        Place placeToTrip = placeRepo.findById(placeId).orElseThrow();
        Trip editedTrip = tripRepo.findById(tripId).orElseThrow();
        editedTrip.addPlace(placeToTrip);
        placeRepo.save(placeToTrip);
        return editedTrip;
    }

    @Override
    public Trip removePlaceFromTrip(Long userId, Long tripId, Long placeId) {
        Place placeFromTrip = placeRepo.findById(placeId).get();
        Trip editedTrip = tripRepo.findById(tripId).get();
        editedTrip.removePlace(placeFromTrip);
        placeRepo.save(placeFromTrip);
        tripRepo.save(editedTrip);
        return editedTrip;
    }

    @Override
    public Trip shareTripWhitOtherUser(Long userId, Long tripId) {
        Trip editedTrip = tripRepo.findById(tripId)
                .orElseThrow(() -> new NotFoundException("The trip with id " + tripId + " doesn't found"));
        List<User> users = userRepo.findAllByTrip(tripRepo.findById(tripId));
        users.add(userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException("The user with id " + tripId + " doesn't found")));
        editedTrip.setTripUsers(users);
        return tripRepo.save(editedTrip);
    }


}
