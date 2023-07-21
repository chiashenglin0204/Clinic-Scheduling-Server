package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to create a new user (doctor or client)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Method to get a user by ID
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Method to update a user
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            // Update the user details based on the updatedUser object
            // For example:
            existingUser.setName(updatedUser.getName());
            existingUser.setContactNumber(updatedUser.getContactNumber());
            // ... other user-specific attributes

            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    // Method to delete a user
    public boolean deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }
}
