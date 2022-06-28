package com.example.demo.user.service;

import com.example.demo.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public User createUser(User user) {
        // TODO business logic
        User createdUser = user;
        return createdUser;
    }

    public User updateUser(User user) {
        // TODO business logic
        User updatedUser = user;
        return updatedUser;
    }

    public User findUser(long userId) {
        // TODO business logic

        User user =
                new User(userId, "sampleId1", "samplePassword1", "유저1","sample@naver.com");
        return user;
    }

    public List<User> findUsers() {
        // TODO business logic
        List<User> users = List.of(
                new User(1, "sampleId1", "samplePassword1", "유저1","sample1@naver.com"),
                new User(2, "sampleId2", "samplePassword2", "유저2","sample2@naver.com")
        );
        return users;
    }

    public void deleteUser(long userId) {
        // TODO business logic
    }
}
