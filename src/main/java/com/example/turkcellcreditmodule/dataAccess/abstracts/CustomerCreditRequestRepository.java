package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCreditRequestRepository extends JpaRepository<CustomerCreditRequest, Integer> {
    CustomerCreditRequest getByCustomerId(int customerId);
    Integer deleteById(int requestId);
    CustomerCreditRequest getById(int requestId);
}
