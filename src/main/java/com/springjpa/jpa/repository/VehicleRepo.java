package com.springjpa.jpa.repository;


import com.springjpa.jpa.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class VehicleRepo {

    Logger logger = LoggerFactory.getLogger(EmplloyeeRepo.class);

    @PersistenceContext
    EntityManager entityManager;

    public Vehicle findById(int id){

        return entityManager.find(Vehicle.class,id);

    }


    //************************ One to Many ********************************//
    public boolean saveWithReviews(Integer vehicleId, List<Review> reviews) {

        Vehicle vehicle = findById(vehicleId);

        logger.info("vehicle  -> {}" , vehicle);

        for (Review review: reviews) {

            // Do Set review in Vehicle and Set vehicle in Review for One-Many
            vehicle.addReviews(review);
            review.setVehicle(vehicle);

            entityManager.persist(review);

        }


        return true;

    }

    //************************ One to Many ********************************//

    //************************ Many to Many ********************************//

    public void findVehiclewithDriver(Integer vehicleId){

        Vehicle vehicle = findById(vehicleId);
        logger.info("findVehiclewithDriver -> Vehicle {} ",vehicle);

        logger.info("findVehiclewithDriver -> Driver {} ",vehicle.getDrivers());

    }

    public boolean saveWithDrivers(Integer vehicleId, List<Driver> drivers) {

        Vehicle vehicle = findById(vehicleId);

        logger.info("vehicle  -> {}" , vehicle);

        for (Driver driver: drivers) {

            // Do Set review in Vehicle and Set vehicle in Review for One-Many
            vehicle.addDrivers(driver);
            driver.addVehicles(vehicle);

            entityManager.persist(driver);
            entityManager.persist(vehicle);

        }


        return true;

    }





    //************************ Many to Many ********************************//

    public void run(){

        List<Review> reviews = new ArrayList();
        reviews.add(new Review("Great"));
        reviews.add(new Review("Super"));

        saveWithReviews(207,reviews );


        findVehiclewithDriver(202);

        List<Driver> drivers = new ArrayList();
        drivers.add(new Driver("Naresh"));
        saveWithDrivers(207,drivers);

    }

}
