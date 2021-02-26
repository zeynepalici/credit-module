package com.example.turkcellcreditmodule.entities.concretes;

import com.example.turkcellcreditmodule.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "credit_limits")
public class CustomerCreditLimit implements IEntity {
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "max_credit_x")
    private double maximumCreditX;
    @Column(name = "max_credit_y")
    private double maximumCreditY;
}
