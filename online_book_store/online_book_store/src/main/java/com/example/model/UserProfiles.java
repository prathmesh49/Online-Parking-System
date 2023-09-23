package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profile_id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String profile_image;
    private String about_me;
}
