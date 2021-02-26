package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditLimit;

public interface ICustomerCreditLimitService {

    Double checkAvailableCreditLimit(int customerId);

    Double checkOneTimeCreditLimit(int customerId);

    boolean takeCreditWithinMonth(int customerId);
}
