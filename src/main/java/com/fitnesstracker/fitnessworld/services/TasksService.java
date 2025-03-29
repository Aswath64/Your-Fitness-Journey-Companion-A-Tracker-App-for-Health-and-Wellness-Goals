package com.fitnesstracker.fitnessworld.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fitnesstracker.fitnessworld.entities.Tasks;
import com.fitnesstracker.fitnessworld.repositories.Tasksrepository;

@Service
public class TasksService {


    @Autowired
    private  Tasksrepository tasksRepository;

   

    public Tasks saveOrUpdate(Tasks task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        Tasks existingTask = tasksRepository.findByEmail(task.getEmail());

        if (existingTask != null) {
            existingTask.setTasks(task.getTasks());
            return tasksRepository.save(existingTask);
        }

        return tasksRepository.save(task);
    }

    public Tasks getTasks(String email) {
        return tasksRepository.findByEmail(email);
    }

}
