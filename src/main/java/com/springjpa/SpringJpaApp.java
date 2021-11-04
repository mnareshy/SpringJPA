package com.springjpa;

import com.springjpa.jdbc.dao.repo.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SpringJpaApp implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(SpringJpaApp.class);

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {

          SpringApplication.run(SpringJpaApp.class);
    }

    @Override
    public void run(String... args) throws Exception {

//        System.out.println(employeeRepository.findAllEmployees());
        logger.info("Employees {} ",employeeRepository.findAllEmployees());
        logger.info("Emplolyee 4 {} ",employeeRepository.findByEmployeeID(4));

    }
}
