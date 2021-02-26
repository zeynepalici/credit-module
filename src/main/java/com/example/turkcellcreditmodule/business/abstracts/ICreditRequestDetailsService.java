package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;

public interface ICreditRequestDetailsService {

    CreditRequestsDetails getByRequestId(int requestId);
    Integer deleteByRequestId(int requestId);
    CreditRequestsDetails add(CreditRequestsDetails creditRequestsDetails);
    String confirmUpdate(CreditRequestsDetails updatedCreditRequest);
    String rejectUpdate(CreditRequestsDetails updatedCreditRequest);
    String responseToUpdateRequest(CreditRequestsDetails updatedCreditRequest, boolean response);
}
