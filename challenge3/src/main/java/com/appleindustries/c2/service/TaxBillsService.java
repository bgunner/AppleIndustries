package com.appleindustries.c2.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appleindustries.c2.constants.Constants;
import com.appleindustries.c2.model.Order;
import com.appleindustries.c2.model.TaxBills;
import com.appleindustries.c2.repository.OrderRepository;
import com.appleindustries.c2.repository.TaxBillsRepository;

@Service
public class TaxBillsService {
	
	@Autowired
	private TaxBillsRepository taxBillsRepository;	
	
	@Autowired
	private OrderRepository orderRepository;
	
	protected TaxBills getTaxBillsByMonthAndYear(Integer month, Integer year){
		
		Optional<TaxBills> optTaxBill = taxBillsRepository.findByMonthAndYear(month, year);
		return optTaxBill.orElseThrow(); 
	}
	
	protected void generateTaxBills() {

		List<Order> allOrders = orderRepository.findAll();	
		
		Map<String, TaxBills> taxesByMonth = new HashMap<>();
		
		int idSeed = 1;
		for(Order order : allOrders) {
			
			if(order.getBonus()) {
				continue;
			}
			
			LocalDate orderDate = order.getOrderDate().toLocalDate();
			
			Integer year = orderDate.getYear();
			Integer month = orderDate.getMonthValue();
			
			String key = month + "-" + year;
			
			TaxBills existingTaxBill = taxesByMonth.get(key);
			
			if(existingTaxBill == null) {
				existingTaxBill = new TaxBills();	
				existingTaxBill.setProfit(order.getPrice());
				existingTaxBill.setId(idSeed);	
				existingTaxBill.setMonth(month);
				existingTaxBill.setYear(year);
				
				Double taxAmount = order.getPrice() * Constants.TAX_RATE;
				taxAmount = Math.round(taxAmount*100)/100.00;
				
				existingTaxBill.setTaxAmount(taxAmount);
				idSeed++;
			}else {
				Double currentProfit = existingTaxBill.getProfit();
				currentProfit += order.getPrice(); 
				existingTaxBill.setProfit(currentProfit);				
				
				Double taxAmount = currentProfit * Constants.TAX_RATE;
				taxAmount = Math.round(taxAmount*100)/100.00;
				existingTaxBill.setTaxAmount(taxAmount);
			}
			
			taxesByMonth.put(key, existingTaxBill);
			
		}		
		
		List<TaxBills> allTaxes = new ArrayList<>(taxesByMonth.values());
		
		if(!allTaxes.isEmpty()) {			
			taxBillsRepository.saveAllAndFlush(allTaxes);
		}

	}

}
