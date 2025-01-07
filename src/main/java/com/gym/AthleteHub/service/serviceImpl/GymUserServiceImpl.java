package com.gym.AthleteHub.service.serviceImpl;

import com.gym.AthleteHub.controller.GymUserController;
import com.gym.AthleteHub.dto.GymUserDTO;
import com.gym.AthleteHub.exceptions.APIException;
import com.gym.AthleteHub.model.GymUsers;
import com.gym.AthleteHub.repository.GymUserRepository;
import com.gym.AthleteHub.response.GymUserResponse;
import com.gym.AthleteHub.service.GymUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymUserServiceImpl implements GymUserService {

    private static final Logger log= LogManager.getLogger(GymUserServiceImpl.class);

    @Autowired
    GymUserRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public GymUserResponse getAllUsers() {
        GymUserResponse response=new GymUserResponse();

        List<GymUsers> users=repository.findAll();
        if(users.isEmpty()){
            throw new APIException("No user present");
        }

        List<GymUserDTO> userDTO=  users.stream()
                .map((user)->modelMapper.map(user,GymUserDTO.class))
                .toList();
        response.setUsers(userDTO);
        return response;
    }

    @Override
    public GymUserDTO createUser(GymUsers user) {
        boolean userAlreadyExists=false;
        boolean usernameAlreadyExists=false;
        List<GymUsers> existingUsers=repository.findAll();
        for(GymUsers existingUser:existingUsers){
            if(existingUser.getEmail().equals(user.getEmail())){
                userAlreadyExists=true;
                break;
            }
            if(existingUser.getUsername().equalsIgnoreCase(user.getUsername())){
                usernameAlreadyExists=true;
                break;
            }
        }
        if(!userAlreadyExists && !usernameAlreadyExists) {
            GymUsers createdUser = repository.save(user);
            log.info("Response: {}",createdUser.toString());
            return modelMapper.map(createdUser,GymUserDTO.class);
        }
        else if(!userAlreadyExists && userAlreadyExists){
            throw new APIException("Please choose a unique username");
        }
        else throw new APIException("User already exists.. Please login");
    }

}
