package com.example.turkcellcreditmodule.entities.concretes;

import com.example.turkcellcreditmodule.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
@Data
@Entity
@Table(name = "yeni_tesis_list")
public class YeniTesis implements IEntity {
@Id
@Column(name = "customer_id")
private int customerId;
@Column(name = "kimlik_belgesi")
private byte[] kimlikBelgesi;
}
