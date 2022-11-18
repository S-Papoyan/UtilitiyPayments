package com.payments.repository;

import com.payments.model.Electricity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityRepository extends JpaRepository<Electricity, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM electricity where social_number_of_customer = ?")
    Electricity getElectricityBySocialNumber(long socialNumber);
}
