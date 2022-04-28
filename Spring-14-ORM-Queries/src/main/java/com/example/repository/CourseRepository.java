package com.example.repository;

import com.example.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the provided name exists. return true if the course exists, false otherwise
    boolean existsByName(String name);

    //returns the count of courses for the provided category
    int countByCategory(String category);

    //find all courses that start with the provided course name
    List<Course> findByNameStartsWith(String name);

    //find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);

    // JPQL - Named parameters with :param1 and @Param("param1")
    @Query("select c from Course c where c.category = :category and c.rating > :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);

    @Modifying
    @Transactional
//    @Query("update Employee e set e.email = 'admin@email.com' where e.id=:id" )
    @Query(value = "update employees set email='admin@email.com' where id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);



}
