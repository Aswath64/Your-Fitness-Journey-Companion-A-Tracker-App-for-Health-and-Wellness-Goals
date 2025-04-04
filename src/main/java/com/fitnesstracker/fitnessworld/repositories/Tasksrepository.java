package com.fitnesstracker.fitnessworld.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.fitnesstracker.fitnessworld.entities.Tasks;

@Repository
public interface Tasksrepository extends JpaRepository<Tasks, Long> {

    Tasks findByEmail(String email);

}
