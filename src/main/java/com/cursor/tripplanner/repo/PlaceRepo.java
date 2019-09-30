package com.cursor.tripplanner.repo;

import com.cursor.tripplanner.model.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaceRepo extends CrudRepository<Place, Long> {

    List<Place> findAllPlacesByCountry(String country);

}
