package com.example.bootstrap;

import com.example.repository.DepartmentRepository;
import com.example.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("---------------REGION START---------------");

        System.out.println("findByCountry: "+regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: "+regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: "+regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry: "+regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("findTop2ByCountry: "+regionRepository.findTop2ByCountry("Canada"));

        System.out.println("---------------REGION END---------------");

        System.out.println("---------------DEPARTMENT START---------------");

        System.out.println("findByDepartment: "+departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivisionIs: "+departmentRepository.findByDivisionIs("Outdoors"));
//        System.out.println("findByDivisionEquals: "+departmentRepository.findByDivisionEquals("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContains: "+departmentRepository.findDistinctTop3ByDivisionContains("Hea"));




        System.out.println("---------------DEPARTMENT END---------------");

    }
}
