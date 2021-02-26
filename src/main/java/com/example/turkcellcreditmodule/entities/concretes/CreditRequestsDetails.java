package com.example.turkcellcreditmodule.entities.concretes;

import com.example.turkcellcreditmodule.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "credit_requests_details")
public class CreditRequestsDetails implements IEntity {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "request_date")
    private Date date;
    @Column(name = "kredi_evrak")
    private byte[] creditEvrak;

    @Column(name = "status_id")
    private int statusId;
}
