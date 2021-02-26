package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCredit;

public interface ICustomerCreditService {

    CustomerCredit add(CreditRequestsDetails creditRequestsDetails);
    String reject(CreditRequestsDetails creditRequestsDetails);
    String update(CreditRequestsDetails updatedCreditRequestDetails, boolean response);
    Double getTotalAmountWithinLastYearByCustomerId(int customerId);
    boolean takeCreditWithinMonth(int customerId);
}
