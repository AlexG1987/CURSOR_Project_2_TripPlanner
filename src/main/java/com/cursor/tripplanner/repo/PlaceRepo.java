package com.cursor.tripplanner.repo;

import com.cursor.tripplanner.model.Place;
import com.cursor.tripplanner.model.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaceRepo extends CrudRepository<Place, Long> {

    List<Place> findAllByTrip (Trip trip);
    List<Place> findAllPlacesByCountry(String country);

}
