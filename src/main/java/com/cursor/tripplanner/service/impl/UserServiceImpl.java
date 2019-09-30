package com.cursor.tripplanner.service.impl;

import com.cursor.tripplanner.model.User;
import com.cursor.tripplanner.repo.UserRepo;
import com.cursor.tripplanner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(Long Id) {
        userRepo.deleteById(Id);
    }

    @Override
    public User editUser(Long oldUserId, User newUser) {
        if (userRepo.existsById(oldUserId)) {
            userRepo.deleteById(oldUserId);
            User user = new User();
            user.setId(oldUserId);
            user.setTrip(newUser.getTrip());
            user.setEmail(newUser.getEmail());
            user.setTripUsers(newUser.getTripUsers());
            user.setUserName(newUser.getUserName());
            user.setUsers(newUser.getTripUsers());
            return userRepo.save(user);
        } else {
            return userRepo.save(newUser);
        }
    }

}
