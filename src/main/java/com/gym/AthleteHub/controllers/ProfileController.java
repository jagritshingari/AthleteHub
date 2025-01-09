package com.gym.AthleteHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.AthleteHub.exceptions.APIException;
import com.gym.AthleteHub.model.Profiles;
import com.gym.AthleteHub.services.impl.ProfileServiceImpl;



@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileServiceImpl profilesService;

    // Create or Update a Profile
    @PostMapping
    public ResponseEntity<?> createOrUpdateProfile(@RequestBody Profiles profile) {
        try {
            Profiles savedProfile = profilesService.createProfiles(profile);
            return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
        } catch (APIException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Long id) {
        try {
            Profiles profile = profilesService.getProfileById(id);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } catch (APIException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Delete Profile by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfileById(@PathVariable Long id) {
        try {
            profilesService.deleteProfileById(id);
            return new ResponseEntity<>("Profile deleted successfully.", HttpStatus.OK);
        } catch (APIException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
