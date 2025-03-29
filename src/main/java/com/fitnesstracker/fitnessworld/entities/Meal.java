package com.fitnesstracker.fitnessworld.entities;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Meal {
    
    @Id
    private Long id;
    private String email;
    @OneToMany
    private List<Dish> breakfast;
    @OneToMany
    private List<Dish> lunch;
    @OneToMany
    private List<Dish> dinner;
    @OneToMany
    private List<Dish> snacks;
    private int total_calories;
    private String date;
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Dish> getBreakfast() {
        return breakfast;
    }
    public void setBreakfast(List<Dish> breakfast) {
        this.breakfast = breakfast;
    }
    public List<Dish> getLunch() {
        return lunch;
    }
    public void setLunch(List<Dish> lunch) {
        this.lunch = lunch;
    }
    public List<Dish> getDinner() {
        return dinner;
    }
    public void setDinner(List<Dish> dinner) {
        this.dinner = dinner;
    }
    public List<Dish> getSnacks() {
        return snacks;
    }
    public void setSnacks(List<Dish> snacks) {
        this.snacks = snacks;
    }
    public int getTotal_calories() {
        return total_calories;
    }
    public void setTotal_calories(int total_calories) {
        this.total_calories = total_calories;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
}
