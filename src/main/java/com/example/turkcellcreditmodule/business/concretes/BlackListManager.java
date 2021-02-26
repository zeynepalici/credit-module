package com.example.turkcellcreditmodule.business.concretes;

import com.example.turkcellcreditmodule.business.abstracts.IBlackListService;
import com.example.turkcellcreditmodule.dataAccess.abstracts.BlackListRepository;
import com.example.turkcellcreditmodule.entities.concretes.BlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlackListManager implements IBlackListService {
    @Autowired
    BlackListRepository blackListRepository;

    public BlackList getByCustomerId(int customerId){
        return blackListRepository.getByCustomerId(customerId);
    }
}
