package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.Meal;
import com.fitnesstracker.fitnessworld.services.MealTrackingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/meals")
public class MealTrackingController {

    @Autowired
    private MealTrackingService mealTrackingService;

    @PostMapping("/add")
    public Meal saveOrUpdateMealTracking(@RequestParam String email, @RequestParam String date,
            @RequestBody Meal meal) {
        meal.setDate(date);
        return mealTrackingService.saveOrUpdateMealTracking(email, meal);
    }

    @GetMapping("/get")
    public Optional<Meal> getMealTrackingByUserAndDate(@RequestParam String email, @RequestParam String date) {
        return mealTrackingService.getMealTrackingByUserAndDate(email, date);
    }
}
