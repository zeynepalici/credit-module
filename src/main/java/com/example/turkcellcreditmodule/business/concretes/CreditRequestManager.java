package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.ICreditRequestService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.CustomerCreditRequestRepository;
import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.Customer;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCredit;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditRequestManager implements ICreditRequestService {

    @Autowired
    private CustomerCreditRequestRepository customerCreditRequestRepository;

    @Autowired
    private CreditRequestDetailsManager creditRequestDetailsManager;

    @Autowired
    private CustomerManager customerManager;

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    public CreditRequestDetailsManager getCreditRequestDetailsManager() {
        return creditRequestDetailsManager;
    }

    public CustomerCreditRequest add(CreditRequestsDetails creditRequestsDetails, String tcNo) {
        Customer customer = customerManager.getByTcNo(tcNo);
        CreditRequestsDetails addedCreditRequestsDetails = creditRequestDetailsManager.add(creditRequestsDetails);

        CustomerCreditRequest customerCreditRequestToAdd = new CustomerCreditRequest();
        customerCreditRequestToAdd.setCustomerId(customer.getId());
        customerCreditRequestToAdd.setId(addedCreditRequestsDetails.getRequestId());

        return customerCreditRequestRepository.save(customerCreditRequestToAdd);
    }

    public CustomerCreditRequest getById(int id) {
        return customerCreditRequestRepository.getById(id);
    }

    public CustomerCreditRequest getByCustomerId(int customerId) {
        return customerCreditRequestRepository.getByCustomerId(customerId);
    }

    public Integer deleteByRequestId(int requestId) {
        return customerCreditRequestRepository.deleteById(requestId);
    }

    public CreditRequestsDetails getByRequestId(int requestId) {
        return creditRequestDetailsManager.getByRequestId(requestId);
    }

}
