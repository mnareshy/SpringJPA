package com.springjpa.jpa;

import com.springjpa.jpa.dao.Driver;
import com.springjpa.jpa.dao.Vehicle;
import com.springjpa.jpa.datarepository.DriverDataRepo;
import com.springjpa.jpa.datarepository.VehicleDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
 ;

@Component
public class JpaDataRunner {

@Autowired
VehicleDataRepo vehicleDataRepo;

@Autowired
DriverDataRepo driverDataRepo;

Logger logger = LoggerFactory.getLogger(JpaDataRunner.class);


    public void run() {

        findVehicleById();
        findAllVehicles();
        findAllVehiclesSortDesc();
        saveVehicles();
        findAllVehiclesPagging();


    }


    private  void findVehicleById(){

    logger.info("JpaDataRunner findVehicleById() -> {}",vehicleDataRepo.findById(201));

    }

    private  void findAllVehicles(){

        logger.info("JpaDataRunner findAllVehicles() -> {}",vehicleDataRepo.findAll());

    }

    public  void findAllVehiclesSortDesc(){

        Sort sort = Sort.by(Sort.Direction.DESC,"vehicleBrand");

        logger.info("JpaDataRunner findAllVehiclesSortDesc() -> {}",vehicleDataRepo.findAll(sort));

    }

    public  void findAllVehiclesPagging(){

        PageRequest pageRequest = PageRequest.of(0,2);


        Page page = vehicleDataRepo.findAll(pageRequest);
        logger.info("JpaDataRunner findAllVehiclesPagging() -> {}",page.getContent());

        Pageable pageable = page.nextPageable();

        page = vehicleDataRepo.findAll(pageable);
        logger.info("JpaDataRunner findAllVehiclesPagging() -> {}",page.getContent());

    }

    private  void saveVehicles(){

        Vehicle vehicle = new Vehicle("SONATA");
        Driver driver = new Driver("Raja");
        vehicle.addDrivers(driver);

        driverDataRepo.save(driver);
        vehicleDataRepo.save(vehicle);


        logger.info("JpaDataRunner findVehicleById() -> {}",vehicleDataRepo.findByVehicleBrand("SONATA"));

    }


}
