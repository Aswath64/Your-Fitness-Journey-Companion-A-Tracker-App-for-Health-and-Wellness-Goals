package com.fitnesstracker.fitnessworld.repositories;

import com.fitnesstracker.fitnessworld.entities.FitnessGoal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessGoalRepository extends JpaRepository<FitnessGoal, Long> {

    @Query("SELECT fg FROM FitnessGoal fg WHERE fg.user.id = :userId")
    Page<FitnessGoal> findByUserId(Long userId, Pageable pageable);
}
