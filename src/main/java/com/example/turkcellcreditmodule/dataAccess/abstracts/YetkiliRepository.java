package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.Yetkili;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YetkiliRepository extends JpaRepository<Yetkili,Integer> {
}
