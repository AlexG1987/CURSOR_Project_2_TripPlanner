package com.cursor.tripplanner.service;

import com.cursor.tripplanner.exceptions.NotFoundException;
import com.cursor.tripplanner.model.*;
import com.cursor.tripplanner.repo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripPlannerImpl implements TripPlanner {

    private final TripRepo tripRepo;
    private final PlaceRepo placeRepo;
    private final CommentRepo commentRepo;
    private final RateRepo rateRepo;
    private final UserRepo userRepo;

    public TripPlannerImpl(TripRepo tripRepo, PlaceRepo placeRepo, CommentRepo commentRepo, RateRepo rateRepo, UserRepo userRepo) {
        this.tripRepo = tripRepo;
        this.placeRepo = placeRepo;
        this.commentRepo = commentRepo;
        this.rateRepo = rateRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Place> showAllPlaces() {
        return (List<Place>) placeRepo.findAll();
    }

    @Override
    public List<Trip> showTripsByUser(User user) {
        return tripRepo.findAllByUser(user);
    }

    @Override
    public List<Place> showPlacesByCountry(String country) {
        return placeRepo.findAllPlacesByCountry(country);
    }

    @Override
    public List<Place> showPlacesByTrip(Trip trip) {
        return placeRepo.findAllByTrip(trip);
    }

    @Override
    public void addTrip(Trip trip) {
        tripRepo.save(trip);
    }

    @Override
    public void deleteTrip(long Id) {
        tripRepo.deleteById(Id);
    }

    @Override
    public void editTrip(Long oldTripId, Trip newTrip) {
        if (tripRepo.existsById(oldTripId)) {
            tripRepo.deleteById(oldTripId);
            tripRepo.save(newTrip);
        } else {
            tripRepo.save(newTrip);
        }
    }

    @Override
    public void commentPlace(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void ratePlace(Rate rate) {
        rateRepo.save(rate);
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(long Id) {
        userRepo.deleteById(Id);
    }

    @Override
    public void editUser(Long oldUserId, User newUser) {
        if (userRepo.existsById(oldUserId)) {
            userRepo.deleteById(oldUserId);
            userRepo.save(newUser);
        } else {
            userRepo.save(newUser);
        }
    }

    @Override
    public Trip shareTripWhitOtherUser(Long userId, Long tripId) {
        Trip editedTrip = tripRepo.findById(tripId).orElseThrow(() -> new NotFoundException("The trip with id " + tripId + " doesn't found"));
        List<User> users = userRepo.findAllByTrip(tripRepo.findById(tripId));
        users.add(userRepo.findById(userId).orElseThrow(() -> new NotFoundException("The user with id " + tripId + " doesn't found")));
        editedTrip.setTripUsers(users);
        return tripRepo.save(editedTrip);
    }

}


