package com.springjpa.jpa.datarepositoryrest;

import com.springjpa.jpa.dao.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDataRepoRest extends JpaRepository<Driver, Integer> {
}
