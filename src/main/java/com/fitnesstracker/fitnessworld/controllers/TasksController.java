package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.Tasks;
import com.fitnesstracker.fitnessworld.services.TasksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping("/add")
    public ResponseEntity<Tasks> addOrUpdateTasks(@RequestBody Tasks tasks) {
        if (tasks.getEmail() == null || tasks.getEmail().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Tasks savedTask = tasksService.saveOrUpdate(tasks);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<Tasks> getTasks(@RequestBody Tasks request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Tasks tasks = tasksService.getTasks(request.getEmail());
        if (tasks != null) {
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
