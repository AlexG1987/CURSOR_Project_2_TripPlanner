package com.cursor.tripplanner.service;

import com.cursor.tripplanner.model.User;
import com.cursor.tripplanner.repo.UserRepo;
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
    public void editUser(Long oldUserId, User newUser) {
        if (userRepo.existsById(oldUserId)) {
            userRepo.deleteById(oldUserId);
            userRepo.save(newUser);
        } else {
            userRepo.save(newUser);
        }
    }

}
