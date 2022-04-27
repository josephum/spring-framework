package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Display all employees with email address ' '
    List<Employee> findByEmail(String email);

    // Display all employees with first name ' ' and lastname ' ', also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName,String email);

    // Display all employees that first name is not ' '
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all employees where last name starts with ' '
    List<Employee> findByLastNameStartsWith(String pattern);

    // Displays all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // Displays all employees with salaries less or equal than ' '
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // Display all employees that have been hired between this date ''  and ''
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    // Display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top unique 3 employees tha are making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    // Custom Queries
    // JPQL, JPA Query Language
    @Query("select e from Employee e where e.email='amcnee1@google.es'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email='amcnee1@google.es'")
    Integer getEmployeeSalary();

    @Query("select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("select e from Employee e where e.email=?1 and e.salary=?2")
    Optional<Employee> getEmployeeDetail(String email, Integer salary);

}
