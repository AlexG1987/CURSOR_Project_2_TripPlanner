package com.cursor.tripplanner.service.impl;

import com.cursor.tripplanner.model.Comment;
import com.cursor.tripplanner.model.Place;
import com.cursor.tripplanner.model.Rate;
import com.cursor.tripplanner.repo.CommentRepo;
import com.cursor.tripplanner.repo.PlaceRepo;
import com.cursor.tripplanner.repo.RateRepo;
import com.cursor.tripplanner.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepo placeRepo;
    private final CommentRepo commentRepo;
    private final RateRepo rateRepo;

    @Override
    public List<Place> getAllPlaces() {
        return (List<Place>) placeRepo.findAll();
    }

    @Override
    public List<Place> getPlacesByCountry(String country) {
        return placeRepo.findAllPlacesByCountry(country);
    }

    @Override
    public List<Place> getPlacesByTrip(Long tripId) {
        return null;
    }

    @Override
    public void addPlace(Place place) {
        placeRepo.save(place);
    }

    @Override
    public void commentPlace(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void ratePlace(Rate rate) {
        rateRepo.save(rate);
    }

}
