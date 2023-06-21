package com.appleindustries.c2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appleindustries.c2.model.TaxBills;

@Repository("taxBillsRepository")
public interface TaxBillsRepository extends JpaRepository<TaxBills, Long> {
	
	Optional<TaxBills> findByMonthAndYear(Integer month, Integer year);
}
