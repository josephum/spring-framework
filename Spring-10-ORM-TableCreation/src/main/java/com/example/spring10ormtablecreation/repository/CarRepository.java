package com.example.spring10ormtablecreation.repository;

import com.example.spring10ormtablecreation.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    //custom methods
    //sql
}
