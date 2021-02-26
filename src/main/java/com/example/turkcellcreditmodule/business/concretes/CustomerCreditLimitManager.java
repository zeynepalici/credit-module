package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.ICustomerCreditLimitService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.CustomerCreditLimitRepository;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreditLimitManager implements ICustomerCreditLimitService {
    @Autowired
    CustomerCreditLimitRepository customerCreditLimitRepository;

    @Autowired
    CustomerCreditManager customerCreditManager;



    private CustomerCreditLimit getByCustomerId(int customerId) {
        return customerCreditLimitRepository.getByCustomerId(customerId);
    }

    public Double checkAvailableCreditLimit(int customerId) {
        return getByCustomerId(customerId).getMaximumCreditY() - customerCreditManager.getTotalAmountWithinLastYearByCustomerId(customerId);
    }

    public Double checkOneTimeCreditLimit(int customerId) {
        return getByCustomerId(customerId).getMaximumCreditX();
    }

    public boolean takeCreditWithinMonth(int customerId){
        return customerCreditManager.takeCreditWithinMonth(customerId);

    }
}
