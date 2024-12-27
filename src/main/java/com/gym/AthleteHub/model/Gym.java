package com.gym.AthleteHub.model;

import java.util.List;

import com.gym.AthleteHub.hubutil.HubUtil;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tbl_gym")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gym {

    @Id
    private String gymId;

    private String gymName;
    private String address;
    private Long contactNumber;

    @OneToMany(mappedBy = "gym")
    private List<GymUsers> gymUser;
    
 // Generate a random 5-character alphanumeric ID
    @PrePersist
    private void generateGymId() {
        if (this.gymId == null || this.gymId.isEmpty()) {
            this.gymId = HubUtil.generateRandomAlphanumeric(5);
        }
    }

    


}
