package com.fitnesstracker.fitnessworld.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activityType;
    private double value;
    private LocalDate logDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) 
    private User user;
}
