package com.fitnesstracker.fitnessworld.services;

import com.fitnesstracker.fitnessworld.entities.FitnessGoal;
import com.fitnesstracker.fitnessworld.repositories.FitnessGoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FitnessGoalService {

    private final FitnessGoalRepository fitnessGoalRepository;

    @Autowired
    public FitnessGoalService(FitnessGoalRepository fitnessGoalRepository) {
        this.fitnessGoalRepository = fitnessGoalRepository;
    }

    public FitnessGoal createGoal(FitnessGoal goal) {
        return fitnessGoalRepository.save(goal);
    }

    public List<FitnessGoal> getAllGoals(String sortBy, String order, int page, int size) {
        Sort sort = order.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return fitnessGoalRepository.findAll(pageRequest).getContent();
    }

    public List<FitnessGoal> getGoalsByUserId(long userId, String sortBy, int page, int size) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<FitnessGoal> goalsPage = fitnessGoalRepository.findByUserId(userId, pageRequest);
        return goalsPage.getContent();
    }

    public void deleteGoal(long id) {
        if (!fitnessGoalRepository.existsById(id)) {
            throw new RuntimeException("Fitness Goal with ID " + id + " not found.");
        }
        fitnessGoalRepository.deleteById(id);
    }
}
