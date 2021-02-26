package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.YeniTesis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YeniTesisRepository extends JpaRepository<YeniTesis, Integer> {
}
