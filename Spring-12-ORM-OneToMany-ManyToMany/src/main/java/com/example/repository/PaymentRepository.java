package com.example.repository;

import com.example.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    // method ---> sql ---> derive query findById(int id) ---> slect * from payment where id=

    List<Payment> findByAmount_One();


    // sql - @Query

    // JPQL - @Query


}
