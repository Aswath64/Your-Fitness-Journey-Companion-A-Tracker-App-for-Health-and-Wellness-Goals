package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.*;
import com.fitnesstracker.fitnessworld.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/goals")
public class FitnessController {

    private final UserService userService;
    private final FitnessGoalService fitnessGoalService;
    private final ChallengeService challengeService;

    public FitnessController(UserService userService, FitnessGoalService fitnessGoalService,
            ChallengeService challengeService) {
        this.userService = userService;
        this.fitnessGoalService = fitnessGoalService;
        this.challengeService = challengeService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> createGoal(@RequestBody FitnessGoal goal) {
        FitnessGoal savedGoal = fitnessGoalService.createGoal(goal);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Goal created successfully!");
        response.put("data", savedGoal);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<List<FitnessGoal>> getAllGoals(
            @RequestParam String sortBy,
            @RequestParam String order,
            @RequestParam int page,
            @RequestParam int size) {
        List<FitnessGoal> goals = fitnessGoalService.getAllGoals(sortBy, order, page, size);
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FitnessGoal>> getGoalsByUserId(
            @PathVariable Long userId) {
        List<FitnessGoal> goals = fitnessGoalService.getGoalsByUserId(userId, "id", 1, 10);
        return ResponseEntity.ok(goals);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        fitnessGoalService.deleteGoal(id);
        return ResponseEntity.noContent().build();
    }

   
}
