package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.dataAccess.abstracts.YeniTesisRepository;
import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import com.example.turkcellcreditmodule.entities.concretes.YeniTesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditRequestManagerForYeniTesis extends CreditRequestManager {

    @Autowired
    YeniTesisManager yeniTesisManager;

    @Override
    public CustomerManager getCustomerManager() {
        return super.getCustomerManager();
    }


    public CustomerCreditRequest add(CreditRequestsDetails creditRequestsDetails, String tcNo, byte[] kimlikBelgesi) {
        YeniTesis yeniTesis = new YeniTesis();
        yeniTesis.setKimlikBelgesi(kimlikBelgesi);
        yeniTesis.setCustomerId(getCustomerManager().getByTcNo(tcNo).getId());
        yeniTesisManager.add(yeniTesis);
        return super.add(creditRequestsDetails, tcNo);
    }

    @Override
    public Integer deleteByRequestId(int requestId) {
        return super.deleteByRequestId(requestId);
    }
}
