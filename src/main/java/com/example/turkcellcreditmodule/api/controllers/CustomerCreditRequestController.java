package com.example.turkcellcreditmodule.api.controllers;


import com.example.turkcellcreditmodule.business.abstracts.IGeneralCreditRequestService;
import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1") // version1
public class CustomerCreditRequestController {

    @Autowired
    IGeneralCreditRequestService generalCreditRequestService;


    @PostMapping("/customerCreditRequests/{tcNo}")
    public CustomerCreditRequest add(@PathVariable(value = "tcNo") String tcNo, @RequestBody CreditRequestsDetails creditRequestsDetails, @RequestParam(required = false) byte[] tcKimlikBelgesi) {
        return generalCreditRequestService.add( tcNo, creditRequestsDetails, tcKimlikBelgesi);
    }

}
