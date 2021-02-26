package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.TurkcellAbonesi;

public interface ITurkcellAbonesiService {
    TurkcellAbonesi getByCustomerId(int customerId);
    boolean inBlackList(String tcNo);
}
