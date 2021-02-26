package com.example.turkcellcreditmodule.entities.concretes;

import com.example.turkcellcreditmodule.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "black_list")
public class BlackList implements IEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_id")
    private int customerId;
}
