package com.springjpa.jpa.repository;

import com.springjpa.SpringJpaApp;
import com.springjpa.jpa.dao.Employee;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes  = SpringJpaApp.class)
public class EmployeeRepoTest {

    private Logger logger = LoggerFactory.getLogger(EmployeeRepoTest.class);

    @Autowired
    EmplloyeeRepo emplloyeeRepo;

    @Test
    public void testFindById(){

        Employee employee =  emplloyeeRepo.findById(4);
        assertNotNull(employee);
        assertEquals("bhimu",employee.getName());

    }



    @Test
    public void testInsertEmployee(){
        Employee employee = new Employee("Prabhu","SpringBoot","Sachin");
        emplloyeeRepo.insertEmployee(employee);
        assertTrue(true);
        assertEquals("Prabhu",emplloyeeRepo.findById(5).getName());

    }


    @Test
    @DirtiesContext
    public void testDeleteEmployee(){

        emplloyeeRepo.deleteEmployee(4);
        assertTrue(true);
        assertNull(emplloyeeRepo.findById(4));

    }

    @Test
    @DirtiesContext
    public void testSaveEmployee(){
        Employee employee = new Employee("Prabhu","SpringBoot","Sachin");
        emplloyeeRepo.save(employee);
        assertTrue(true);

        Employee employee1 = new Employee(4,"Prabhu","SpringBoot","Sachin");
        emplloyeeRepo.save(employee1);
        assertTrue(true);
    }

}
