package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.Customer;

public interface ICustomerService {
    Customer getByTcNo(String tcNo);
}
