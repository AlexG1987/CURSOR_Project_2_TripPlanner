package com.cursor.tripplanner.controller;

import com.cursor.tripplanner.model.User;
import com.cursor.tripplanner.service.TripPlannerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

class UserController {

    private final TripPlannerImpl tripPlannerImpl;

    @Autowired
    public UserController(TripPlannerImpl tripPlannerImpl) {
        this.tripPlannerImpl = tripPlannerImpl;
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user) {
        tripPlannerImpl.addUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") long userId) {
        tripPlannerImpl.deleteUser(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/editUser/{id}")
    public ResponseEntity editUser(@PathVariable("id") Long oldUserId, @RequestBody User newUser) {
        tripPlannerImpl.editUser(oldUserId, newUser);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
