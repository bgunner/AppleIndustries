package com.appleindustries.c2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Time;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;

import com.appleindustries.c2.model.Order;
import com.appleindustries.c2.model.PhotoPackage;

@SpringBootTest(classes = { com.appleindustries.c2.app.Application.class })
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Sql(scripts = {
		"classpath:/data.sql" }, config = @SqlConfig(transactionMode = TransactionMode.ISOLATED), executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class OrderServiceTest {

	@Autowired
	private OrderService service;

	@Test
	public void testgetCustomer() {

		Order someOrder = new Order();
		someOrder.setCustomerId(1L);

		Order returnedOrder = service.getOrder(1L);
		assertEquals(someOrder.getCustomerId(), returnedOrder.getCustomerId());
	}

	@Test
	public void testgetCustomer_nonExistent() {
		Long nonExistentId = 999L;
		assertThrows(NoSuchElementException.class, () -> {
			service.getOrder(nonExistentId);
		});
	}

	@Test
	public void testgenerateWinningPrize_nonExistent() {
		
		Time initialTime = Time.valueOf("15:00:00"); 
		Time endTime = Time.valueOf("16:00:00"); 
		
		assertThrows(NoSuchElementException.class, ()->{service.generateWinningPrize(initialTime, endTime);} );
	}
	
	@Test
	public void testgetBonusesOrders_nonExistent() {
				
		assertThrows(NoSuchElementException.class, ()->{service.getBonusesOrders();} );
	}
	
	@Test
	public void testgetAllPackages() {
				
		List<PhotoPackage> allPackages = service.getAllPackages();
		
		assertEquals(3, allPackages.size());
	}
	
	@Test
	public void testgenerateWinningPrize() {

		Time initialTime = Time.valueOf("10:00:00"); 
		Time endTime = Time.valueOf("11:00:00"); 
		
		service.generateWinningPrize(initialTime, endTime);
		
		List<Order> bonusesOrders = service.getBonusesOrders();
		
		assertEquals(2, bonusesOrders.size());
		
		Order bonus1 = bonusesOrders.get(0);
		Order bonus2 = bonusesOrders.get(1);
		
		assertEquals(2, bonus1.getPackageId());
		assertEquals(1, bonus1.getCustomerId());
		assertEquals(true, bonus1.getBonus());
		
		assertEquals(3, bonus2.getPackageId());
		assertEquals(1, bonus2.getCustomerId());
		assertEquals(true, bonus2.getBonus());
		
		
	}

}

