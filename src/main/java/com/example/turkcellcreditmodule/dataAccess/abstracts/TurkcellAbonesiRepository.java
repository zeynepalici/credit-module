package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.TurkcellAbonesi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurkcellAbonesiRepository extends JpaRepository<TurkcellAbonesi, Integer> {

    TurkcellAbonesi getByCustomerId(int customerId);
}
