package com.springjpa.jpa.dao;

import javax.persistence.*;

@Entity
public class Passport {


    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Passport() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String passportNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport") //if you dont use mappedBy , One-One relation data stores in both Tables
    Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
