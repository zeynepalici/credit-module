package com.example.turkcellcreditmodule.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_yetkili")
public class CustomerYetkili {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "customer_id")
    int customerId;

    @Column(name = "yetkili_id")
    int yetkiliId;
}
