package com.appleindustries.c2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appleindustries.c2.model.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findById(Long id);
}
