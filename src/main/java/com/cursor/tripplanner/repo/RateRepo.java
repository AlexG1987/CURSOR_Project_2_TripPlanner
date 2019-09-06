package com.cursor.tripplanner.repo;

import com.cursor.tripplanner.model.Rate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RateRepo extends CrudRepository<Rate, Long> {

    List<Rate> findAll();

}
