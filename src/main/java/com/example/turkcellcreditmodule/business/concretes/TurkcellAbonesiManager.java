package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.ITurkcellAbonesiService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.TurkcellAbonesiRepository;
import com.example.turkcellcreditmodule.entities.concretes.Customer;
import com.example.turkcellcreditmodule.entities.concretes.TurkcellAbonesi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurkcellAbonesiManager implements ITurkcellAbonesiService {

    @Autowired
    TurkcellAbonesiRepository turkcellAbonesiRepository;

    @Autowired
    BlackListManager blackListManager;

    @Autowired
    CustomerManager customerManager;

    public TurkcellAbonesi getByCustomerId(int customerId) {
        return turkcellAbonesiRepository.getByCustomerId(customerId);
    }


    public boolean inBlackList(String tcNo) {
        Customer customer = customerManager.getByTcNo(tcNo);
        return blackListManager.getByCustomerId(customer.getId()) != null;

    }
}
