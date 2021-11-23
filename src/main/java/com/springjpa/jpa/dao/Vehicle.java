package com.springjpa.jpa.dao;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries(value = {
        @NamedQuery(name = "FindVehiclesByName", query = "Select v From Vehicle v where vehicleBrand like '%a'")


})
@Entity
public class Vehicle {


    public Vehicle(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public Vehicle() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String vehicleBrand;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle")
    List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "vehicle_driver_join",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id"))
    List<Driver> drivers = new ArrayList<>();

    public void addReviews(Review review) {
        this.reviews.add(review);
    }

    public void aremoveReviews(Review review) {
        this.reviews.remove(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }


    public void addDrivers(Driver driver) {
        this.drivers.add(driver);
    }

    public void aremoveDrivers(Driver driver) {
        this.drivers.remove(driver);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                '}';
    }
}
