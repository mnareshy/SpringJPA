package com.springjpa.jpa.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {

    public Driver() {
    }

    public Driver(String name) {
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @ManyToMany(mappedBy = "drivers")
    List<Vehicle> vehicles =  new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addVehicles(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void aremoveVehicles(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }



    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
