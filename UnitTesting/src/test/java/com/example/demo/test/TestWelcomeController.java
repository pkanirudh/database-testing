package com.example.demo.test;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controllers.WelcomeController;
import com.example.demo.service.LoanEligibility;

@RunWith(SpringRunner.class)
public class TestWelcomeController {

	private MockMvc mock;
	
	@Mock
	private LoanEligibility service;
	
	@InjectMocks
	private WelcomeController controller;
	
	@Before
	public void setup() {
		
		this.mock = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testGetMessage() throws Exception {
		
		mock.perform(get("/greet")).andExpect(status().isOk()).andExpect(content().string("testing"));
	}
	
//	@Test
//	public void testGetEligibility() throws Exception {
//		when(service.checkEligibility(200000,"govt")).thenReturn(500000.00);
//		
//		mock.perform(get("/check").param("yearlyIncome", "300000").
//				contentType(MediaType.APPLICATION_JSON).param("employment", "govt")).
//		andExpect(content().contentType(MediaType.APPLICATION_JSON));
//	}
	
	@Test
	public void testGetEligibility() throws Exception {
		when(service.checkEligibility(200000,"govt")).thenReturn(500000.00);
		
		mock.perform(get("/check{yearlyIncome}/{employment}", 300000.0, "govt")).
		andExpect(content().string("500000.0"));
	}
}