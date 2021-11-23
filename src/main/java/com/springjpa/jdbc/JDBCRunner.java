package com.springjpa.jdbc;

import com.springjpa.SpringJpaApp;
import com.springjpa.jdbc.dao.Employee;
import com.springjpa.jdbc.dao.repo.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JDBCRunner {

    Logger logger = LoggerFactory.getLogger(SpringJpaApp.class);

    @Autowired
    EmployeeRepository employeeRepository;

    public void run(){


        //        System.out.println(employeeRepository.findAllEmployees());
        logger.info("Employees {} ",employeeRepository.findAllEmployees());
        logger.info("Employees -> findAllEmployeesWithEmployeeRowMapper {} ",employeeRepository.findAllEmployeesWithEmployeeRowMapper());

        logger.info("Emplolyee 4 {} ",employeeRepository.findByEmployeeID(4));
        logger.info("Delete Employee {}",employeeRepository.deleteByEmployeeID(3));
        logger.info("INSERT EMPLOYEE {}",employeeRepository.insertEmployee(new Employee(7,"Bobbili","AI","Bobbili Raja")));

        logger.info("UPDATE EMPLOYEE {}",employeeRepository.updateEmployee(new Employee(2,"Bobbili","AI","Bobbili Raja"),8));

    }

}
