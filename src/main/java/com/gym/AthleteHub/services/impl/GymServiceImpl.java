package com.gym.AthleteHub.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gym.AthleteHub.dto.PageableResponse;
import com.gym.AthleteHub.exceptions.APIException;
import com.gym.AthleteHub.hubutil.HubUtil;
import com.gym.AthleteHub.model.Gym;
import com.gym.AthleteHub.repositories.GymRepository;
import com.gym.AthleteHub.services.GymService;

@Service
public class GymServiceImpl implements GymService {

    @Autowired
    private GymRepository gymRepository;

    @Override
    public Gym createGym(Gym gym) {
        try {
            return gymRepository.save(gym);
        } catch (Exception ex) {
            throw new APIException("Error creating gym: " + ex.getMessage());
        }
    }

    @Override
    public Gym updateGym(String gymId, Gym gym) {
        Gym existingGym = gymRepository.findById(gymId).orElseThrow(() -> new APIException("Gym not found with the given id"));
        existingGym.setGymName(gym.getGymName());
        existingGym.setAddress(gym.getAddress());
        existingGym.setContactNumber(gym.getContactNumber());
        return gymRepository.save(existingGym);
    }

    @Override
    public void deleteGym(String gymId) {
        Gym gym = gymRepository.findById(gymId).orElseThrow(() -> new APIException("Gym not found with the given id"));
        gymRepository.delete(gym);
    }

    @Override
    public PageableResponse<Gym> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase("Desc")) ? Sort.by(sortBy).descending() : Sort.by(sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Gym> gymList = gymRepository.findAll(pageable);
        return HubUtil.getPageableResponse(gymList);
    }

    @Override
    public Gym get(String gymId) {
        return gymRepository.findById(gymId).orElseThrow(() -> new APIException("Gym not found with the given id"));
    }

    @Override
    public List<Gym> getGymByKeyword(String keyword) {
        return gymRepository.findByGymNameContainingIgnoreCaseOrAddressContainingIgnoreCase(keyword,keyword);
    }
}
