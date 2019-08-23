package com.example.demo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.LoanEligibility;


@RunWith(SpringRunner.class)
@ContextConfiguration("AppConfig.class")
public class LoanEligibilityTest {

	@Autowired
	private LoanEligibility service;
	
	@Test
	public void testEligibilityForBusiness() {
		double actual = service.checkEligibility(200000, "business");
		double expected = 500000;
		
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testEligibilityForGovtEmployees() {
		
		double actual = service.checkEligibility(300000, "govt");
		double expected = 700000;
		
		assertEquals(expected, actual, 0);
	}
	
}
