package com.gym.AthleteHub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gym.AthleteHub.dto.PageableResponse;
import com.gym.AthleteHub.model.Gym;
import com.gym.AthleteHub.services.GymService;

@RestController
@RequestMapping("/api/gyms")
public class GymController {

    @Autowired
    private GymService gymService;

    @PostMapping
    public ResponseEntity<Object> createGym(@RequestBody Gym gym) {
        return gymService.createGym(gym);
    }

    @PutMapping("/{gymId}")
    public ResponseEntity<Object> updateGym(@PathVariable String gymId, @RequestBody Gym gym) {
        return gymService.updateGym(gymId, gym);
    }

    @DeleteMapping("/{gymId}")
    public ResponseEntity<Object> deleteGym(@PathVariable String gymId) {
        return gymService.deleteGym(gymId);
    }

    @GetMapping
    public PageableResponse<Gym> getAllGyms(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "gymName") String sortBy,
            @RequestParam(defaultValue = "Asc") String sortDir) {
        return gymService.getAll(pageNumber, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{gymId}")
    public ResponseEntity<Object> getGymById(@PathVariable String gymId) {
        return gymService.get(gymId);
    }

    @GetMapping("/search")
    public List<Gym> searchGymsByKeyword(@RequestParam String keyword) {
        return gymService.getGymByKeyword(keyword);
    }
}
