package com.test.room;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import org.springframework.boot.test.context.SpringBootTest;

import com.test.room.service.CustomerService;
import com.test.room.service.CustomerServiceImpl;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class RoomManagementApplicationTests {
	
	
	
	@InjectMocks 
	   CustomerServiceImpl serviceImpl = new CustomerServiceImpl();
	@Mock
	   CustomerService customerservice;

	@Test
	void contextLoads() {
		when(customerservice.validateCustomerId(1234)).thenReturn(true);
		Assert.assertEquals(serviceImpl.validateCustomerId(1234),true);
	}

}
