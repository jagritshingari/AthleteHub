package com.gym.AthleteHub.controller;

import com.gym.AthleteHub.dto.GymUserDTO;
import com.gym.AthleteHub.model.GymUsers;
import com.gym.AthleteHub.response.GymUserResponse;
import com.gym.AthleteHub.service.GymUserService;
import org.apache.catalina.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
//@RequestMapping("/")
public class GymUserController {
private static final Logger log= LogManager.getLogger(GymUserController.class);
    @Autowired
    GymUserService service;

    @GetMapping("/sa/AllUsers")
    public ResponseEntity<GymUserResponse> getAllUsers(){
    return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);

    }

    @PostMapping("/admin/user")
    public ResponseEntity<GymUserDTO> createUser(@RequestBody GymUsers user) {
        log.info("Request: {}",user);
        GymUserDTO createdUser=service.createUser(user);
        log.info("Response: {}",createdUser);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/gym/{gymId}/user/{userId}")



    }

