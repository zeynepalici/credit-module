package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, Integer> {

    BlackList getByCustomerId(int customerId);
}
