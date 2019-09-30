package com.cursor.tripplanner.service;

import com.cursor.tripplanner.model.User;

public interface UserService {

    void addUser(User user);

    void deleteUser(Long Id);

    User editUser(Long oldUserId, User newUser);

}
