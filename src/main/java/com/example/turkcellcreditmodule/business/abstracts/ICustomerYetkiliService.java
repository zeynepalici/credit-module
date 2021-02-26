package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;

import java.util.List;

public interface ICustomerYetkiliService {
    List<Integer> getAllCustomersByYetkiliId(int yetkiliId);
    List<CustomerCreditRequest> getCustomerRequestsByYetkiliId(int yetkiliId);
}
