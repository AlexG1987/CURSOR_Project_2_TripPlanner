package com.cursor.tripplanner.repo;

import com.cursor.tripplanner.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findAllByTrip(Long tripId);

}
