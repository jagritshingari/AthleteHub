package com.gym.AthleteHub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

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
