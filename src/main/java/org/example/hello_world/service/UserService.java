package org.example.hello_world.service;

import org.example.hello_world.entities.User;
import org.example.hello_world.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public User updateUser(Long id, User newUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setFullName(newUser.getFullName());
            existingUser.setUserName(newUser.getUserName());
            existingUser.setGender(newUser.getGender());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}