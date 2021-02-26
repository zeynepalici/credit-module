package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRequestDetailsRepository extends JpaRepository<CreditRequestsDetails, Integer> {
 CreditRequestsDetails getByRequestId(int requestId);
 Integer deleteByRequestId(int requestId);
}
