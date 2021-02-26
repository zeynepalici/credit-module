package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.IYeniTesisService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.YeniTesisRepository;
import com.example.turkcellcreditmodule.entities.concretes.YeniTesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YeniTesisManager implements IYeniTesisService {

    @Autowired
    YeniTesisRepository yeniTesisRepository;
    public YeniTesis add(YeniTesis yeniTesis){
       return yeniTesisRepository.save(yeniTesis);
    }
}
