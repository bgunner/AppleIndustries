package com.appleindustries.c2.service;

import java.sql.Time;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appleindustries.c2.model.Order;
import com.appleindustries.c2.model.PhotoPackage;
import com.appleindustries.c2.repository.OrderRepository;
import com.appleindustries.c2.repository.PhotoPackageRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PhotoPackageRepository photoPackageRepository;

	protected Order getOrder(Long id) {

		Optional<Order> optOrder = orderRepository.findById(id);
		return optOrder.orElseThrow();

	}
	
	protected void generateWinningPrize(Time initialTime, Time endTime) {

		List<Order> allOrders = orderRepository.findByOrderTimeBetween(initialTime, endTime);
		
		if(allOrders.isEmpty()) {
			throw new NoSuchElementException();			
		}
		
		Order winningOrder = allOrders.get(0);
		
		List<PhotoPackage> allPackages = photoPackageRepository.findAll();
		
		int idSeed = 1;
		for(PhotoPackage pk : allPackages) {
			
			if(winningOrder.getPackageId().equals(pk.getId())) {
				continue;
			}
			
			Order bonusOrder = new Order();
			bonusOrder.setId(winningOrder.getId() * 100 + idSeed);
			bonusOrder.setBonus(true);
			bonusOrder.setCustomerId(winningOrder.getCustomerId());
			bonusOrder.setPackageId(pk.getId());		
			
			orderRepository.saveAndFlush(bonusOrder);
			idSeed++;
		}

	}
	
	protected List<PhotoPackage> getAllPackages(){
		return photoPackageRepository.findAll();
	}
	
	protected List<Order> getBonusesOrders(){
		List<Order> allOrders = orderRepository.findByBonusTrue();
		
		if(allOrders.isEmpty()) {
			throw new NoSuchElementException();			
		}
				
		return allOrders;
	}
	
	
	
}
