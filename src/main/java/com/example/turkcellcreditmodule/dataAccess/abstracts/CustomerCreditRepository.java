package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CustomerCredit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerCreditRepository extends JpaRepository<CustomerCredit, Integer> {

    CustomerCredit getByCustomerId(int customerId);


    List<CustomerCredit> getAllByCustomerId(int customerId);
}
