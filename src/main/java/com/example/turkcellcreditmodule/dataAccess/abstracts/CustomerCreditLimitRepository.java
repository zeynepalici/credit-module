package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditLimit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCreditLimitRepository extends JpaRepository<CustomerCreditLimit, Integer> {
    CustomerCreditLimit getByCustomerId(int customerId);

    boolean existsByCustomerIdAndMaximumCreditXGreaterThan(int customerId, double requestedCredit);
}
