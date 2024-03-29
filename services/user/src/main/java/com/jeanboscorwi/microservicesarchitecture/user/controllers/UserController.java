package com.jeanboscorwi.microservicesarchitecture.user.controllers;

import com.jeanboscorwi.microservicesarchitecture.user.models.User;
import com.jeanboscorwi.microservicesarchitecture.user.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @RequestMapping( method = {RequestMethod.GET})
    ResponseEntity<String> index() {
        log.info("request received");
        return ResponseEntity.ok("microservice is running");
    }


    @RequestMapping( path = "/users", method = {RequestMethod.GET})
    ResponseEntity<Collection<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @RequestMapping( path = "/users/{userId}", method = {RequestMethod.GET})
    ResponseEntity<User> getUser(@PathVariable long userId) throws Exception{
        return ResponseEntity.ok(userService.getUser(userId));
    }
}
