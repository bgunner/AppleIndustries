package com.appleindustries.c2.repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appleindustries.c2.model.Order;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {

	Optional<Order> findById(Long id);
	
	List<Order> findByOrderTimeBetween(Time initialTime, Time endTime);
	
	List<Order> findByBonusTrue();
	
}
