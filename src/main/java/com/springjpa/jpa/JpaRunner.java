package com.springjpa.jpa;

import com.springjpa.SpringJpaApp;
import com.springjpa.jpa.dao.Employee;
import com.springjpa.jpa.dao.Vehicle;
import com.springjpa.jpa.jpql.JPQLWe;
import com.springjpa.jpa.repository.EmplloyeeRepo;
import com.springjpa.jpa.repository.PassportRepo;
import com.springjpa.jpa.repository.ReviewRepo;
import com.springjpa.jpa.repository.VehicleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaRunner {

    @Autowired
    EmplloyeeRepo emplloyeeRepo;

    @Autowired
    PassportRepo passportRepo;

    @Autowired
    JPQLWe jpqlWe;

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    ReviewRepo reviewRepo;

    Logger logger = LoggerFactory.getLogger(SpringJpaApp.class);




    public void run(){

        logger.info("Emplolyee 4 {} ",emplloyeeRepo.findById(4));

       /* Employee employee = new Employee(12,"Prabhu","SpringBoot","Sachin");
        emplloyeeRepo.insertEmployee(employee);*/
        logger.info("INSERT EMPLOYEE {}",emplloyeeRepo.insertEmployee(new Employee("Bobbili","AI","Bobbili Raja")));
        logger.info("UPDATE EMPLOYEE {}",emplloyeeRepo.updateEmployee(new Employee(12,"Bobbili","AI","Bobbili Raja")));

        logger.info("DELETE EMPLOYEE --> ");
        emplloyeeRepo.deleteEmployee(2);

        logger.info("FIND ALL EMPLOYEES --> {} ",emplloyeeRepo.findAllEmployees());

        emplloyeeRepo.flushClearDetach();
        emplloyeeRepo.relations();
        passportRepo.relations();

        // JPQL
        jpqlWe.JPQLWeRun();

        vehicleRepo.run();
        reviewRepo.run();


    }

}
