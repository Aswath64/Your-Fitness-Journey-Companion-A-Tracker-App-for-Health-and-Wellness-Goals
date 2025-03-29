package com.fitnesstracker.fitnessworld.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Dish {

    @Id
    private Long id;
    private String food_name;
    private String cal_per_100_ml_or_gms;
    private Double quantity;

    public Dish() {
    }

    public Dish(String food_name, String cal_per_100_ml_or_gms, Double quantity) {
        this.food_name = food_name;
        this.cal_per_100_ml_or_gms = cal_per_100_ml_or_gms;
        this.quantity = quantity;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getCal_per_100_ml_or_gms() {
        return cal_per_100_ml_or_gms;
    }

    public void setCal_per_100_ml_or_gms(String cal_per_100_ml_or_gms) {
        this.cal_per_100_ml_or_gms = cal_per_100_ml_or_gms;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
