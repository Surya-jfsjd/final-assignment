package com.password.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.password.password.Repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        String firstName = user.getFirstName();
        String middleName = user.getMiddleName();
        String lastName = user.getLastName();
        String password = generatePassword(firstName, middleName, lastName);
        user.setPassword(password);
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    private String generatePassword(String firstName, String middleName, String lastName) {
        String password = "";
        password += firstName.substring(0, 2);
        password += middleName.substring(0, 2);
        password += lastName.substring(0, 2);

        int randomDigits = (int)(Math.random() * 1000);
        password += randomDigits;

        return password;
    }
}