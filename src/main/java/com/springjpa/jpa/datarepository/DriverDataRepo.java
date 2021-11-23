package com.springjpa.jpa.datarepository;

import com.springjpa.jpa.dao.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDataRepo extends JpaRepository<Driver, Integer> {
}
