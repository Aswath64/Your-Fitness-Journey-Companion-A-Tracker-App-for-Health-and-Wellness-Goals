package com.fitnesstracker.fitnessworld.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;
    private String col;
    private String value;

    public String getCol() {
        return col;
    }

    public void setColumn(String col) {
        this.col = col;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
