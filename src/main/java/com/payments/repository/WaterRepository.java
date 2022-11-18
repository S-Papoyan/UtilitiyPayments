package com.payments.repository;

import com.payments.model.Water;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterRepository extends JpaRepository<Water, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM water where social_number_of_customer = ?")
    Water getWaterCustomerBySocialNumber (long socialNumber);
}
