package com.example.turkcellcreditmodule.entities.concretes;

import com.example.turkcellcreditmodule.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers_credits")
public class CustomerCredit implements IEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "customer_id")
    private int customerId;
}
