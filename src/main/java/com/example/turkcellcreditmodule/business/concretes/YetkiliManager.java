package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.IYetkiliService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.YetkiliRepository;
import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCredit;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class YetkiliManager implements IYetkiliService {

    @Autowired
    YetkiliRepository yetkiliRepository;
    @Autowired
    CustomerYetkiliManager customerYetkiliManager;
    @Autowired
    CreditRequestManager creditRequestManager;
    @Autowired
    CustomerCreditManager customerCreditManager;

    public List<CustomerCreditRequest> getAllRequestsByCustomerId(int yetkiliId) {
        List<CustomerCreditRequest> customerCreditRequests = new ArrayList<>();

        for (int customerId : customerYetkiliManager.getAllCustomersByYetkiliId(yetkiliId)) {
            customerCreditRequests.add(creditRequestManager.getByCustomerId(customerId));
        }
        return customerCreditRequests;
    }

    @Transactional
    public CustomerCredit add(int requestId) {
        return customerCreditManager.add(creditRequestManager.getByRequestId(requestId));
    }

    @Transactional
    public String reject(int requestId) {
        return customerCreditManager.reject(creditRequestManager.getByRequestId(requestId));
    }

    @Transactional
    public String update(CreditRequestsDetails updatedCreditRequestDetails, boolean response) {
        return customerCreditManager.update(updatedCreditRequestDetails,response);
    }

}
