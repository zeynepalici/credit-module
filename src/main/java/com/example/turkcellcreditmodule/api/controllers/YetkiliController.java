package com.example.turkcellcreditmodule.api.controllers;


import com.example.turkcellcreditmodule.business.abstracts.IYetkiliService;
import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCredit;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1") // version1
public class YetkiliController {
    @Autowired
    IYetkiliService yetkiliService;

    @PostMapping("/yetkili/confirm/{requestId}")
    public CustomerCredit add(@PathVariable(value = "requestId") int requestId) {
        return yetkiliService.add(requestId);
    }

    @PostMapping("/yetkili/reject/{requestId}")
    public String reject(@PathVariable(value = "requestId") int requestId) {
        return yetkiliService.reject(requestId);
    }

    @PostMapping("/yetkili/update/{response}")
    public String update(@RequestBody CreditRequestsDetails updatedCreditRequestDetails, @PathVariable boolean response) {
        return yetkiliService.update(updatedCreditRequestDetails, response);
    }

    @GetMapping("/yetkili/{yetkiliId}")
    List<CustomerCreditRequest> getCustomerRequestsByYetkiliId(@PathVariable(value = "yetkiliId")int yetkiliId){
        return yetkiliService.getAllRequestsByCustomerId(yetkiliId);
    }
}
