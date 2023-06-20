package com.appleindustries.c2.model;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_package_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "package_id")
	private Long packageId;
	
	@Column(name = "order_time")
	private Time orderTime;
	
	@Column(name = "bonus")
	private Boolean bonus;

}
