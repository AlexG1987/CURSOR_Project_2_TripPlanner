package com.cursor.tripplanner.repo;

import com.cursor.tripplanner.model.Trip;
import com.cursor.tripplanner.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepo extends CrudRepository<Trip, Long> {

    List<Trip> findAllByUser(User user);

}
