package com.example.turkcellcreditmodule.business.concretes;


import com.example.turkcellcreditmodule.business.abstracts.ICustomerCreditService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.CustomerCreditRepository;
import com.example.turkcellcreditmodule.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerCreditManager implements ICustomerCreditService {
    @Autowired
    CustomerCreditRepository customerCreditRepository;


    @Autowired
    CustomerCreditDetailsManager customerCreditDetailsManager;
    @Autowired
    CreditRequestManager creditRequestManager;


    @Autowired
    CreditRequestDetailsManager creditRequestDetailsManager;


    private List<Integer> getCreditIdsByCustomerId(int customerId) {
        List<CustomerCredit> customerCredits = customerCreditRepository.getAllByCustomerId(customerId);
        return customerCredits.stream().map(CustomerCredit::getId).collect(Collectors.toList());
    }

    private void deleteCreditRequest(int requestId) {
        creditRequestManager.deleteByRequestId(requestId);
        creditRequestDetailsManager.deleteByRequestId(requestId);
    }

    public CustomerCredit add(CreditRequestsDetails creditRequestsDetails) {
        CustomerCreditDetails customerCreditDetails = new CustomerCreditDetails();
        customerCreditDetails.setAmount(creditRequestsDetails.getAmount());
        customerCreditDetails.setCreditDate(Calendar.getInstance().getTime());

        CustomerCreditDetails addedCreditDetails = customerCreditDetailsManager.add(customerCreditDetails);

        CustomerCreditRequest customerCreditRequest = creditRequestManager.getById(creditRequestsDetails.getRequestId());
        CustomerCredit customerCredit = new CustomerCredit();
        customerCredit.setCustomerId(customerCreditRequest.getCustomerId());
        customerCredit.setId(addedCreditDetails.getCreditId());

        deleteCreditRequest(creditRequestsDetails.getRequestId());
        return customerCreditRepository.save(customerCredit);
    }


    public String reject(CreditRequestsDetails creditRequestsDetails) {
        CustomerCreditRequest customerCreditRequest = creditRequestManager.getById(creditRequestsDetails.getRequestId());
        deleteCreditRequest(creditRequestsDetails.getRequestId());
        return customerCreditRequest.getCustomerId() + " müşteri numaralı müşteri olarak kredi talebiniz reddedildi.";
    }

    public String update(CreditRequestsDetails updatedCreditRequestDetails, boolean response) {
        return creditRequestDetailsManager.responseToUpdateRequest(updatedCreditRequestDetails, response);
    }

    public Double getTotalAmountWithinLastYearByCustomerId(int customerId) {
        return customerCreditDetailsManager.amountWithinLastYear(getCreditIdsByCustomerId(customerId));
    }

    public boolean takeCreditWithinMonth(int customerId) {
        return customerCreditDetailsManager.takeCreditWithinMonth(getCreditIdsByCustomerId(customerId));
    }
}

