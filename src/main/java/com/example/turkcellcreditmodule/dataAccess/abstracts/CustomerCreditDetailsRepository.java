package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CustomerCreditDetailsRepository extends JpaRepository<CustomerCreditDetails, Integer> {
    CustomerCreditDetails getByCreditDateAfterAndCreditId(Date date,  int creditId);
}
