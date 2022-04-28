package com.example.bootstrap;

import com.example.entity.Course;
import com.example.repository.CourseRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
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


        System.out.println("---------------EMPLOYEE START---------------");

        System.out.println("getEmployeeDetail: "+employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary: "+employeeRepository.getEmployeeSalary());
        System.out.println("getEmployeeSalary: "+employeeRepository.getEmployeeDetail("amcnee1@google.es"));
        System.out.println("getEmployeeSalary: "+employeeRepository.getEmployeeDetail("amcnee1@google.es",56752));

        System.out.println("---------------EMPLOYEE END---------------");

        System.out.println("---------------COURSE START---------------");
        courseRepository.findByCategory("Spring").forEach(System.out::println);

        System.out.println("---------------------------");

        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);

        System.out.println("---------------------------");

        System.out.println(courseRepository.existsByName("JavaScript for All"));

        System.out.println("---------------------------");

        System.out.println(courseRepository.countByCategory("Spring"));

        System.out.println("---------------------------");

        courseRepository.findByNameStartsWith("Scalable").forEach(System.out::println);

        System.out.println("---------------------------");

//        courseRepository.streamByCategory("Spring").forEach(System.out::println);


        System.out.println("---------------COURSE END---------------");

    }
}
