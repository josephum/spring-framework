package com.example.repository;

import com.example.entity.Department;
import com.example.entity.Employee;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    // Display all departments in the furniture department
    List<Department> findByDepartment(String department);

    // Display all departments in the Health Division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // Display top 3 departments with divisionname includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);

    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentDivision(List<String> division);

    // Named queries
    @Query
    List<Department> retrieveDepartmentByDivision(String division);
    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);

}
