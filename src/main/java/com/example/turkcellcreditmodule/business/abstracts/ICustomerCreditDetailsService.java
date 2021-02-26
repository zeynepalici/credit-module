package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditDetails;

import java.util.List;

public interface ICustomerCreditDetailsService {

    CustomerCreditDetails add(CustomerCreditDetails customerCreditDetails);
    double amountWithinLastYear(List<Integer> creditIds);
    boolean takeCreditWithinMonth(List<Integer> creditIds);
}
