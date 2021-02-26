package com.example.turkcellcreditmodule.entities.concretes;

import com.example.turkcellcreditmodule.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "yetkili")
public class Yetkili implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lasName;

}
