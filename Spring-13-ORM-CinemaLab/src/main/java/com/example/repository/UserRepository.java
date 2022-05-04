package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<User> findUserByEmail(String email);

    //Write a derived query to read a user with an username?
    Optional<User> findUserByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByUsernameContains(String keyword);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findAllByUsernameIgnoreCaseContains(String keyword);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccountAgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> retrieveUserByEmailJPQL(@Param("email") String email);

    //Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> retrieveUserByUsername(@Param("username") String username);

    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM User u")
    List<User> retrieveAllUsersJPQL();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT * FROM user_account WHERE username ILIKE CONCAT('%',?1,'%')",nativeQuery = true)
    List<User> retrieveAllByUsernameContaining(@Param("keyword") String keyword);

    //Write a native query that returns all users?
    @Query(value = "SELECT * FROM user_account",nativeQuery = true)
    List<User> retrieveAllUsersNativeQuery();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad " +
            "ON ua.id = ad.id WHERE ad.age BETWEEN ?1 AND ?2", nativeQuery = true)
    List<User> retrieveAllUsersInRangeOfAge(@Param("age1") Integer age1, @Param("age2") Integer age2);

    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM user_account WHERE email = ?1",nativeQuery = true)
    Optional<User> retrieveUserByEmailNativeQuery(@Param("email") String email);


}
