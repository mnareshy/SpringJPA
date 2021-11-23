package com.springjpa;

import com.springjpa.jdbc.dao.Employee;
import com.springjpa.jdbc.JDBCRunner;
import com.springjpa.jdbc.dao.repo.EmployeeRepository;
import com.springjpa.jpa.JpaDataRunner;
import com.springjpa.jpa.JpaRunner;
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
    JDBCRunner jdbcRunner;

    @Autowired
    JpaRunner jpaRunner;

    @Autowired
    JpaDataRunner jpaDataRunner;



    public static void main(String[] args) {

          SpringApplication.run(SpringJpaApp.class);
    }

    @Override
    public void run(String... args) throws Exception {
        //USING JDBC TEMPLATE
        //jdbcRunner.run();

        //USING JPA
        jpaRunner.run();

        //Using JPAData
        jpaDataRunner.run();


    }
}
