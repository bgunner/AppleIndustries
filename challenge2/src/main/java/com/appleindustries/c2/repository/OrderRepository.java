package com.appleindustries.c2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appleindustries.c2.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
