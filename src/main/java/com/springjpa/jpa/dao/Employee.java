package com.springjpa.jpa.dao;

import javax.persistence.*;

@Entity
@NamedQueries(value = {
            @NamedQuery(name = "FindEmployeesByNameNQ", query = "Select emp From Employee emp where emp.name = :name")


})
@NamedQuery(name = "Find_All_Employees",query = "SELECT emp FROM Employee emp")//Named Quesy is in HQL, used in repo for FInd all Employees
public class Employee {

    public Employee(String name, String dept, String reports) {
        this.name = name;
        this.dept = dept;
        this.reports = reports;
    }

    public Employee(int id, String name, String dept, String reports) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.reports = reports;
    }
    public Employee(){}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String dept;
    String reports;

    //@OneToOne  //by default it takese EAGELY Fetch - which loads relations along with actual entity - But Lazy Ensures that the loading
    // of relational Entity is Lazy
    @OneToOne(fetch = FetchType.LAZY)
    Passport passport;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getReports() {
        return reports;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", reports='" + reports + '\'' +
                '}';
    }
}
