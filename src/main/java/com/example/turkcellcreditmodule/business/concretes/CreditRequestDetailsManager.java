package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.ICreditRequestDetailsService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.CreditRequestDetailsRepository;
import com.example.turkcellcreditmodule.dataAccess.abstracts.CustomerCreditRequestRepository;
import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditRequestDetailsManager implements ICreditRequestDetailsService {
    @Autowired
    CreditRequestDetailsRepository creditRequestDetailsRepository;

    @Autowired
    CustomerCreditRequestRepository customerCreditRequestRepository;

    public CreditRequestsDetails getByRequestId(int requestId) {
        return creditRequestDetailsRepository.getByRequestId(requestId);
    }

    public Integer deleteByRequestId(int requestId) {
        return creditRequestDetailsRepository.deleteByRequestId(requestId);
    }

    public CreditRequestsDetails add(CreditRequestsDetails creditRequestsDetails) {
        return creditRequestDetailsRepository.save(creditRequestsDetails);
    }

    public String confirmUpdate(CreditRequestsDetails updatedCreditRequest) {
        CreditRequestsDetails originalRequestDetails = creditRequestDetailsRepository.getByRequestId(updatedCreditRequest.getRequestId());
        if (updatedCreditRequest.getCreditEvrak() == null)
            updatedCreditRequest.setCreditEvrak(originalRequestDetails.getCreditEvrak());
        if (updatedCreditRequest.getAmount() == 0)
            updatedCreditRequest.setAmount(originalRequestDetails.getAmount());

        creditRequestDetailsRepository.save(updatedCreditRequest);
        return "Kredi isteği güncellendi";
    }

    public String rejectUpdate(CreditRequestsDetails updatedCreditRequest) {
        creditRequestDetailsRepository.deleteByRequestId(updatedCreditRequest.getRequestId());
        customerCreditRequestRepository.deleteById(updatedCreditRequest.getRequestId());

        return "Müşteri güncellemeyi reddetti. Request silindi.";
    }

    public String responseToUpdateRequest(CreditRequestsDetails updatedCreditRequest, boolean response) {
        if (response)
            return confirmUpdate(updatedCreditRequest);
        return rejectUpdate(updatedCreditRequest);
    }

    public CustomerCreditRequest getAllByCustomerId(int customerId){
     return    customerCreditRequestRepository.getByCustomerId(customerId);

    }
}
