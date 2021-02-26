package com.example.turkcellcreditmodule.entities.concretes;

import com.example.turkcellcreditmodule.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "abone_list")
public class TurkcellAbonesi implements IEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "customer_id")
    private int customerId;

}
