package com.appleindustries.c2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;

import com.appleindustries.c2.model.Customer;

@SpringBootTest(classes={com.appleindustries.c2.app.Application.class})
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CustomerServiceTest {
	
	@Autowired 
	private CustomerService service;
	
	@Test
	@Sql(scripts={"classpath:/data.sql"}, 
    config=@SqlConfig(transactionMode = TransactionMode.ISOLATED), 
    executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void testgetCustomer() {
		
		Customer kennyCustomer = new Customer();
		kennyCustomer.setName("Kenny");	
		
		Customer customer = service.getCustomer(4L);
		assertEquals(kennyCustomer.getName(),customer.getName());
	}
	
}
