package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;

public interface IGeneralCreditRequestService {
    CustomerCreditRequest add( String tcNo, CreditRequestsDetails creditRequestsDetails,byte[] kimlikBelgesi);
}
