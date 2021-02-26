package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.ICustomerCreditDetailsService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.CustomerCreditDetailsRepository;
import com.example.turkcellcreditmodule.entities.concretes.CreditRequestsDetails;
import com.example.turkcellcreditmodule.entities.concretes.CustomerCreditDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CustomerCreditDetailsManager implements ICustomerCreditDetailsService {
    @Autowired
    CustomerCreditDetailsRepository customerCreditDetailsRepository;




    public CustomerCreditDetails add(CustomerCreditDetails customerCreditDetails){
       return customerCreditDetailsRepository.save(customerCreditDetails);
    }


    public double amountWithinLastYear(List<Integer> creditIds) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        Date date = calendar.getTime();

        List<CustomerCreditDetails> customerCreditDetails = new ArrayList<>();

        for (Integer creditId : creditIds) {
            customerCreditDetails.add(customerCreditDetailsRepository.getByCreditDateAfterAndCreditId(date, creditId));
        }

        return customerCreditDetails.stream().mapToDouble(CustomerCreditDetails::getAmount).sum();
    }

    public boolean takeCreditWithinMonth(List<Integer> creditIds) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date date = calendar.getTime();

        for (Integer creditId : creditIds) {
            if (customerCreditDetailsRepository.getByCreditDateAfterAndCreditId(date, creditId) != null)
                return true;
        }

        return false;
    }
}
