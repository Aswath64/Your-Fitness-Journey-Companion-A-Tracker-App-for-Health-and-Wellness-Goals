package com.fitnesstracker.fitnessworld.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.fitnesstracker.fitnessworld.entities.Meal;

import java.util.Optional;

@Repository
public interface Mealrepository extends JpaRepository<Meal, Long> {

    Optional<Meal> findByEmailAndDate(String email, String date);

    void deleteByEmailAndDate(String email, String date);
}
