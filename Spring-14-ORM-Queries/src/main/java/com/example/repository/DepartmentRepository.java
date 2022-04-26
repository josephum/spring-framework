package com.example.repository;

import com.example.entity.Department;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    // Display all departments in the furniture department
    List<Department> findByDepartment(String department);

    // Display all departments in the Health Division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // Display top 3 departments with divisionname includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);


}
