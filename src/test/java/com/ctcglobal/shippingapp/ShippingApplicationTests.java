package com.ctcglobal.shippingapp;

import static org.mockito.Mockito.when;

import com.ctcglobal.shippingapp.controller.ShippingController;
import com.ctcglobal.shippingapp.model.Order;
import com.ctcglobal.shippingapp.model.OrderForm;
import com.ctcglobal.shippingapp.model.ShippingChart;
import com.ctcglobal.shippingapp.repo.OrderRepository;
import com.ctcglobal.shippingapp.repo.ShippingChartRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShippingApplicationTests {

	/*@LocalServerPort
	int randomServerPort;

	@Test
	void ContextLoads() {
	}*/

	@Autowired
	private ShippingController shippingcontroller;

	@MockBean
	private ShippingChartRepository shippingchartrepository;
	@MockBean
	private OrderRepository orderrepository;

	@Test
	public void getLocationNumberTest() {
		when(shippingchartrepository.findAll()).thenReturn(Stream.of(
				new ShippingChart("sd549n", 26, 57), new ShippingChart("asda", 1, 2)
		).collect(Collectors.toList()));
		assertEquals(2, shippingcontroller.getAll().size());
	}

	@Test
	public void getLocationbyAddressTest() {
		String location="asda";
		when(shippingchartrepository.findByLocation(location)).thenReturn(
				new ShippingChart(location, 11, 2)
		);
		assertEquals(11, shippingcontroller.getOne(location).getX());
	}

	@Test
	public void checkLocationTest()
	{
		String location="asda";
		when(shippingchartrepository.existsShippingChartByLocation(location)).thenReturn(
				true
		);
		assertTrue(shippingcontroller.checkLocation(location));
	}

	/*@Test
	public void addOrderTest()
	{
		ShippingChart location1 = new ShippingChart("test1", 100, 100);
		ShippingChart location2 = new ShippingChart("test2", 0, 0);
		shippingchartrepository.save(location1);
		shippingchartrepository.save(location2);
		OrderForm order1 = new OrderForm("testorder", "test1", "test2",12);
		shippingcontroller.addOrder(order1);
		Order foundOrder = orderrepository.findByName("testorder");
		assertEquals("testorder", foundOrder.getName());
	}*/

}

