package com.appleindustries.c2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

import com.appleindustries.c2.model.TaxBills;

@SpringBootTest(classes={com.appleindustries.c2.app.Application.class})
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Sql(scripts={"classpath:/data.sql"}, 
config=@SqlConfig(transactionMode = TransactionMode.ISOLATED), 
executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class TaxBillsServiceTest {
	
	@Autowired 
	private TaxBillsService service;
	
	@Test
	public void testgetTaxBillsByMonthAndYear_nonExistent() {
						
		assertThrows(NoSuchElementException.class, ()->{service.getTaxBillsByMonthAndYear(1, 2023);} );
	}
	
	@Test
	public void testgenerateTaxBills() {

		service.generateTaxBills();
		
		TaxBills resultTaxBill = service.getTaxBillsByMonthAndYear(1, 2023);
		
		assertEquals(17, resultTaxBill.getProfit());
		assertEquals(1.47, resultTaxBill.getTaxAmount());
		
		
		resultTaxBill = service.getTaxBillsByMonthAndYear(2, 2023);
		
		assertEquals(12, resultTaxBill.getProfit());
		assertEquals(1.03, resultTaxBill.getTaxAmount());
		
		assertThrows(NoSuchElementException.class, ()->{service.getTaxBillsByMonthAndYear(3, 2023);} );
		
	}
	
}
