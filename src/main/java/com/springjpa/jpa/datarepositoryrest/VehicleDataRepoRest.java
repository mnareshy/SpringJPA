package com.springjpa.jpa.datarepositoryrest;

import com.springjpa.jpa.dao.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "vehicle")
public interface VehicleDataRepoRest extends JpaRepository<Vehicle, Integer> {

       Vehicle findByVehicleBrand(String vehicleBrand);

       List<Vehicle> queryByVehicleBrand(String vehicleBrand);

       List<Vehicle> findByVehicleBrandAndId(String vehicleBrand, Integer id);
       List<Vehicle> deleteByVehicleBrand(String vehicleBrand);

       @Query("select v from Vehicle v where vehicleBrand like '%a'")
       List<Vehicle> findByVehicleBrandEndswitA();

       @Query(value = "select * from Vehicle v where vehicleBrand like '%a'", nativeQuery = true)
       List<Vehicle> findByVehicleBrandEndswitAnativeQuery();

       @Query(name = "FindVehiclesByName")
       List<Vehicle> findByVehicleBrandEndswitANamedQuery();

}
