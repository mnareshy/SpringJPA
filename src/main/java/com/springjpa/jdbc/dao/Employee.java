package com.springjpa.jdbc.dao;

public class Employee {

    public Employee(Integer id, String name, String dept, String reports) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.reports = reports;
    }
    Employee(){}


    Integer id;
    String  name;
    String dept;
    String reports;

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
