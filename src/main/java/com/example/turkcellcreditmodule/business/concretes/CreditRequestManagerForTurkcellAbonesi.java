package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditRequestManagerForTurkcellAbonesi extends CreditRequestManager {
    @Autowired
    private CustomerCreditLimitManager customerCreditLimitManager;

    @Autowired
    private TurkcellAbonesiManager turkcellAbonesiManager;

    @Override
    public CustomerManager getCustomerManager() {
        return super.getCustomerManager();
    }

    @Override
    public CustomerCreditRequest add(CreditRequestsDetails creditRequestsDetails, String tcNo) {
        int customerId = getCustomerManager().getByTcNo(tcNo).getId();

        boolean inBlackList = turkcellAbonesiManager.inBlackList(tcNo);
        boolean exceedOneTimeCreditLimit = customerCreditLimitManager.checkOneTimeCreditLimit(customerId) < creditRequestsDetails.getAmount();
        boolean exceedOneYearCreditLimit = customerCreditLimitManager.checkAvailableCreditLimit(customerId) < creditRequestsDetails.getAmount();
        boolean takeCreditWithinLastMonth = customerCreditLimitManager.takeCreditWithinMonth(customerId);

        if (inBlackList || exceedOneTimeCreditLimit || exceedOneYearCreditLimit || takeCreditWithinLastMonth)
            return null;

        return super.add(creditRequestsDetails, tcNo);
    }

    @Override
    public Integer deleteByRequestId(int requestId) {
        return super.deleteByRequestId(requestId);
    }
}
