package com.cursor.tripplanner.controller;

import com.cursor.tripplanner.model.User;
import com.cursor.tripplanner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable(name = "id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity editUser(@PathVariable(name = "id") Long oldUserId, @RequestBody User newUser) {
        userService.editUser(oldUserId, newUser);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
