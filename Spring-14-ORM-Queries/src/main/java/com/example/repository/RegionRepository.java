package com.example.repository;

import com.example.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {

    // Display all regions in Canada
    List<Region> findByCountry(String country); // select * from region where country="xxx"

    // Display all regions in Canada, without duplicate
    List<Region> findDistinctByCountry(String country);

    // Display all regions with country name includes 'United'
    List<Region> findByCountryContaining(String str);

    // Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainingOrderByCountry(String country);

    // Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);


}
