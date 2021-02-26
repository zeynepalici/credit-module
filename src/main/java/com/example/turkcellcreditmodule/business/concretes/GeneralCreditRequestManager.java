package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.IGeneralCreditRequestService;
import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralCreditRequestManager implements IGeneralCreditRequestService {
    @Autowired
    TurkcellAbonesiManager turkcellAbonesiManager;

    @Autowired
    CreditRequestManagerForTurkcellAbonesi creditRequestManagerForTurkcellAbonesi;

    @Autowired
    CreditRequestManagerForYeniTesis creditRequestManagerForYeniTesis;


    private boolean isTurkcellAbonesi(int customerId) {
        return turkcellAbonesiManager.getByCustomerId(customerId) != null;
    }

    public CustomerCreditRequest add(String tcNo, CreditRequestsDetails creditRequestsDetails, byte[] kimlikBelgesi) {
        int customerId = creditRequestManagerForTurkcellAbonesi.getCustomerManager().getByTcNo(tcNo).getId();

        if (isTurkcellAbonesi(customerId))
            return creditRequestManagerForTurkcellAbonesi.add(creditRequestsDetails, tcNo);
        else
            return creditRequestManagerForYeniTesis.add(creditRequestsDetails, tcNo, kimlikBelgesi);
    }

}
