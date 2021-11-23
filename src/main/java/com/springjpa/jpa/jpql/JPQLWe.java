package com.springjpa.jpa.jpql;

import com.springjpa.jpa.dao.Employee;
import com.springjpa.jpa.dao.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Component
public class JPQLWe {

    private Logger logger = LoggerFactory.getLogger(JPQLWe.class);

    @Autowired
    EntityManager entityManager;


    public List<Employee> findAllEmployees_Query(){

        Query query =   entityManager.createQuery("Select emp From Employee emp");
        List employeeList = query.getResultList();

        return employeeList;

    }

    public List<Employee> findAllEmployees_TypedQuery(){

        TypedQuery typedQuery =   entityManager.createQuery("Select emp From Employee emp", Employee.class);
        List employeeList = typedQuery.getResultList();

        return employeeList;

    }

    public List<Employee> findEmployeeByName_TypedQuery(){

        TypedQuery typedQuery =   entityManager.createQuery("Select emp From Employee emp where name is 'sairam'", Employee.class);
        List employeeList = typedQuery.getResultList();

        return employeeList;

    }

    public List<Employee> findEmployeeByName_NamedQuery(){

        Query namedQuery =   entityManager.createNamedQuery("FindEmployeesByNameNQ", Employee.class);
        namedQuery.setParameter("name","sairam");
        List employeeList = namedQuery.getResultList();

        return employeeList;

    }

    public List joinVehicleDriver(){

        Query query =   entityManager.createQuery("Select v , d from Vehicle v join v.drivers d");
        List<Object []> vehicleDriver = query.getResultList();

        for (Object[] vehicleDrivers:vehicleDriver) {

            logger.info("joinVehicleDriver -> {}", vehicleDrivers[0]);
            logger.info("joinVehicleDriver -> {}",vehicleDrivers[1]);

        }

        return vehicleDriver;

    }


    // *********** Criteria Queries **************//

    public List<Vehicle> selectVehiclesEndsWithA(){

        // Select v from vehicle v where vehicleBrand like '%a';

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> vehicleCriteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
        Root<Vehicle> vehicleRoot = vehicleCriteriaQuery.from(Vehicle.class);

        Predicate predicate = criteriaBuilder.like(vehicleRoot.get("vehicleBrand"),"%a");
        vehicleCriteriaQuery.where(predicate);

        TypedQuery<Vehicle> typedQuery = entityManager.createQuery(vehicleCriteriaQuery.select(vehicleRoot));
        List<Vehicle> vehicleList = typedQuery.getResultList();

        return vehicleList;

    }


    public List joinVehicleDriverCQ(){

        // Select v from vehicle v join v.drivers d;

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> vehicleCriteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
        Root<Vehicle> vehicleRoot = vehicleCriteriaQuery.from(Vehicle.class);

        Join<Object, Object> drivers = vehicleRoot.join("drivers");

        TypedQuery<Vehicle> typedQuery = entityManager.createQuery(vehicleCriteriaQuery.select(vehicleRoot));
        List vehicleList = typedQuery.getResultList();



        return vehicleList;


    }
    // *********** Criteria Queries **************//

    public void JPQLWeRun(){

        logger.info("**** JPQLWe  findAllEmployees_Query {} ",findAllEmployees_Query());
        logger.info("**** JPQLWe  findAllEmployees_TypedQuery {} ",findAllEmployees_TypedQuery());
        logger.info("**** JPQLWe  findEmployeeByName_TypedQuery {} ",findEmployeeByName_TypedQuery());
        logger.info("**** JPQLWe  findEmployeeByName_NamedQuery {} ",findEmployeeByName_NamedQuery());

        logger.info("**** JPQLWe  joinVehicleDriver {} ",joinVehicleDriver() );
        logger.info("**** JPQLWe  selectVehiclesEndsWithA {} ",selectVehiclesEndsWithA() );
        logger.info("**** JPQLWe  joinVehicleDriverCQ {} ",joinVehicleDriverCQ() );

    }


}
