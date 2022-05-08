package com.mobile.testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.MobileServiceImpl;

class MobileTestcases {

	IMobileService mobileservice;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		 mobileservice=new MobileServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		mobileservice=null;
	}

	@Test
	@DisplayName("Testing id")
	void testGetById() throws MobileNotFoundException {
		Mobile mobile=mobileservice.getById(101);
		assertNotNull(mobile);
	}
	@Test
	@DisplayName("Testing id not available")
	void testGetByInvalidId() throws MobileNotFoundException {
		//Mobile mobile=mobileservice.getById(100);
		assertThrows(MobileNotFoundException.class,()->mobileservice.getById(100));
	}
	
	@Test
	@DisplayName("Testing same object")
	void testGetByIdEquals() throws MobileNotFoundException {
		Mobile mobile1=new Mobile(110,"M32","Samsung",17000);
		Mobile mobile=mobileservice.getById(101);
		assertEquals(mobile1.toString(),mobile.toString());
	}
	@Test
	@DisplayName("Testing by brand not available")
	void testGetByBrandNotAvailable() throws MobileNotFoundException {
		assertThrows(MobileNotFoundException.class,()->mobileservice.getByBrand("Redmi"));
	}
	@Test
	@DisplayName("Testing by brand")
	void testGetByBrand() throws MobileNotFoundException {
		List<Mobile> mobilesbybrand=mobileservice.getByBrand("Samsung");
		assertNotNull(mobilesbybrand);
	}
	
}
