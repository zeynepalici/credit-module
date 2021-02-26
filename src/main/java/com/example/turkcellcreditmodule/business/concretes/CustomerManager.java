package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.ICustomerService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.CustomerRepository;
import com.example.turkcellcreditmodule.entities.concretes.Customer;
import com.example.turkcellcreditmodule.entities.concretes.TurkcellAbonesi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TurkcellAbonesiManager turkcellAbonesiManager;




    public Customer getByTcNo(String tcNo){
        return customerRepository.getByTcNo(tcNo);
    }


}
