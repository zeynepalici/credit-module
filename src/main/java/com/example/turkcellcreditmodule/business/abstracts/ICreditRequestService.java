package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.business.concretes.CreditRequestDetailsManager;
import com.example.turkcellcreditmodule.business.concretes.CustomerManager;
import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;

public interface ICreditRequestService {

    CustomerManager getCustomerManager();
    CreditRequestDetailsManager getCreditRequestDetailsManager();
    CustomerCreditRequest add(CreditRequestsDetails creditRequestsDetails, String tcNo);
    CustomerCreditRequest  getById(int id);
    CustomerCreditRequest getByCustomerId(int customerId);
    Integer deleteByRequestId(int requestId);
    CreditRequestsDetails getByRequestId(int requestId);


}
