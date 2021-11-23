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
    JdbcTemplate  jdbcTemplate;

    @Autowired
    EmployeeRowMapper employeeRowMapper;


    public List<Employee> findAllEmployees(){

        return  jdbcTemplate.query("SELECT * FROM employee",new BeanPropertyRowMapper(Employee.class));

    }

    public List<Employee> findAllEmployeesWithEmployeeRowMapper(){

        return  jdbcTemplate.query("SELECT * FROM employee",employeeRowMapper);

    }


    public Employee findByEmployeeID(int empID){

        return (Employee) jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?",new Object[]{empID}
                    ,new BeanPropertyRowMapper(Employee.class));

    }

    public int deleteByEmployeeID(int empID){

        return  jdbcTemplate.update("DELETE  FROM employee WHERE id = ?",new Object[]{empID});

    }

    public int insertEmployee(Employee employee){

        return  jdbcTemplate.update("INSERT INTO employee(id, name, dept, reports) " +
                " VALUES(? ,? ,? ,?) ",new Object[]{employee.getId(), employee.getName(), employee.getDept(),
                    employee.getReports()});

    }


    public int updateEmployee(Employee employee,int id){

        return  jdbcTemplate.update("UPDATE employee SET id = ?, name = ? , dept =? , reports = ?" +
                "  WHERE  id = ? ",new Object[]{ id, employee.getName(), employee.getDept(),
                employee.getReports(),employee.getId()});

    }


}
