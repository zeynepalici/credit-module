package com.example.turkcellcreditmodule.entities.concretes;

import com.example.turkcellcreditmodule.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "customers_credits_details")
public class CustomerCreditDetails implements IEntity {

    @Id
    @Column(name = "credit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int creditId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "credit_date")
    private Date creditDate;

}
