package com.fitnesstracker.fitnessworld.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fitnesstracker.fitnessworld.repositories.Mealrepository;
import com.fitnesstracker.fitnessworld.entities.Meal;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Service
public class MealTrackingService {

    @Autowired
    private Mealrepository mealRepository;

    @Transactional
    public Meal saveOrUpdateMealTracking(String email, Meal meal) {

        mealRepository.deleteByEmailAndDate(email, meal.getDate());

        meal.setEmail(email);
        return mealRepository.save(meal);

    }

    public Optional<Meal> getMealTrackingByUserAndDate(String email, String date) {
        return mealRepository.findByEmailAndDate(email, date).stream().findFirst();
    }
}
