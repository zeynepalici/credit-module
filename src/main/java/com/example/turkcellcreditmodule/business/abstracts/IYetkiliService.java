package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCredit;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;

import java.util.List;

public interface IYetkiliService {
    List<CustomerCreditRequest> getAllRequestsByCustomerId(int yetkiliId);

     CustomerCredit add(int requestId);

     String reject(int requestId);

    String update(CreditRequestsDetails updatedCreditRequestDetails, boolean response);
}
