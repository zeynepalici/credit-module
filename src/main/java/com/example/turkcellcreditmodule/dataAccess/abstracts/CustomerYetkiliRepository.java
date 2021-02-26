package com.example.turkcellcreditmodule.dataAccess.abstracts;

import com.example.turkcellcreditmodule.entities.concretes.CustomerYetkili;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerYetkiliRepository extends JpaRepository<CustomerYetkili,Integer>
{
List<CustomerYetkili> getAllByYetkiliId(int yetkiliId);
}
