package com.example.turkcellcreditmodule.business.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.BlackList;

public interface IBlackListService {

    BlackList getByCustomerId(int customerId);
}
