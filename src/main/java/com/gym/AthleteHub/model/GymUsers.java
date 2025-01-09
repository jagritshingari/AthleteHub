package com.gym.AthleteHub.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tbl_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GymUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING) // Maps enum to database as a String
    private Role role; // Change `role` to a field and use the enum
    private enum Role{
        Admin,User,Trainer
    };

    private Date createdAt;
    
    @OneToOne(mappedBy = "gymUsers")
    private Profiles profiles;

//    @OneToMany(mappedBy = "gymUsers")
//    private List<Attendance> attendance;

    @ManyToOne
    @JoinColumn(name = "gymId")
    private Gym gym;

}
