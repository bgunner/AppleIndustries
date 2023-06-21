package com.appleindustries.c2.model;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_package_order")
public class Order {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "package_id")
	private Long packageId;
	
	@Column(name = "order_time")
	private Time orderTime;
	
	@Column(name = "bonus")
	private Boolean bonus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public Time getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Time orderTime) {
		this.orderTime = orderTime;
	}

	public Boolean getBonus() {
		return bonus;
	}

	public void setBonus(Boolean bonus) {
		this.bonus = bonus;
	}

}
