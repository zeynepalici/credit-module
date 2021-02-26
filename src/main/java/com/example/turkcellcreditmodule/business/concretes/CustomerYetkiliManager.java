package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.ICustomerYetkiliService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.CustomerYetkiliRepository;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import com.example.turkcellcreditmodule.entities.concretes.CustomerYetkili;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerYetkiliManager implements ICustomerYetkiliService {
    @Autowired
    CustomerYetkiliRepository customerYetkiliRepository;

    @Autowired
    CreditRequestDetailsManager creditRequestDetailsManager;

    public List<Integer> getAllCustomersByYetkiliId(int yetkiliId) {
        return customerYetkiliRepository.getAllByYetkiliId(yetkiliId).stream().map(CustomerYetkili::getCustomerId).collect(Collectors.toList());
    }

    public List<CustomerCreditRequest> getCustomerRequestsByYetkiliId(int yetkiliId){
        List<CustomerCreditRequest> customerCreditRequests = new ArrayList<>();
        List<Integer> customerIds = getAllCustomersByYetkiliId(yetkiliId);
        for (Integer customerId: customerIds) {
            customerCreditRequests.add(  creditRequestDetailsManager.getAllByCustomerId(customerId));
        }
        return customerCreditRequests;
    }
}
