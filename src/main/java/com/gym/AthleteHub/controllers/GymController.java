package com.gym.AthleteHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gym.AthleteHub.model.Gym;
import com.gym.AthleteHub.services.GymService;
import com.gym.AthleteHub.exceptions.APIException;

@RestController
@RequestMapping("/api/gyms")
public class GymController {

    @Autowired
    private GymService gymService;

    @PostMapping
    public ResponseEntity<Object> createGym(@RequestBody Gym gym) {
        try {
            Gym savedGym = gymService.createGym(gym);
            return new ResponseEntity<>(savedGym, HttpStatus.CREATED);
        } catch (APIException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{gymId}")
    public ResponseEntity<Object> updateGym(@PathVariable String gymId, @RequestBody Gym gym) {
        try {
            Gym updatedGym = gymService.updateGym(gymId, gym);
            return new ResponseEntity<>(updatedGym, HttpStatus.OK);
        } catch (APIException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{gymId}")
    public ResponseEntity<Object> deleteGym(@PathVariable String gymId) {
        try {
            gymService.deleteGym(gymId);
            return new ResponseEntity<>("Gym successfully deleted", HttpStatus.OK);
        } catch (APIException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{gymId}")
    public ResponseEntity<Object> getGym(@PathVariable String gymId) {
        try {
            Gym gym = gymService.get(gymId);
            return new ResponseEntity<>(gym, HttpStatus.OK);
        } catch (APIException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllGyms(@RequestParam int pageNumber, @RequestParam int pageSize,
                                              @RequestParam String sortBy, @RequestParam String sortDir) {
        try {
            return new ResponseEntity<>(gymService.getAll(pageNumber, pageSize, sortBy, sortDir), HttpStatus.OK);
        } catch (APIException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Object> getGymsByKeyword(@RequestParam String keyword) {
        try {
            return new ResponseEntity<>(gymService.getGymByKeyword(keyword), HttpStatus.OK);
        } catch (APIException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
