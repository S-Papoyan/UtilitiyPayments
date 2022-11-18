package com.payments.repository;

import com.payments.model.Gas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GasRepository extends JpaRepository<Gas, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM gas where social_number_of_customer = ?")
    Gas getGasCustomerBySocialNumber (long socialNumber);
}
