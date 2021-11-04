package com.springjpa.jdbc.dao.repo;

import com.springjpa.jdbc.dao.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> findAllEmployees(){

        return  jdbcTemplate.query("SELECT * FROM employee",new BeanPropertyRowMapper(Employee.class));

    }


    public Employee findByEmployeeID(int empID){

        return (Employee) jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?",new Object[]{empID}
                    ,new BeanPropertyRowMapper(Employee.class));

    }
}
