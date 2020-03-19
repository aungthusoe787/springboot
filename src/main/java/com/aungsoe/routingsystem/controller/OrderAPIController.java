package com.aungsoe.routingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aungsoe.routingsystem.bean.OrdersDTO;
import com.aungsoe.routingsystem.domain.Orders;
import com.aungsoe.routingsystem.service.OrderService;
import com.aungsoe.routingsystem.util.CommonConstant.VehicleType;

@RestController
@RequestMapping("/")
public class OrderAPIController {

	@Autowired
	private OrderService orderService;
	
	
	@GetMapping
	public String sayHello() {
	   return "Hello and Welcome to the Routing System!";
	}
	
	@GetMapping("/attach_vehicle_orders")
	public List<OrdersDTO> attachedVehicleWithAllOrders(){
		List<Orders> ordersList = orderService.getOrderAll();
		
		return orderService.attachedVehicleWithAllOrders(ordersList);
	}
	
	@GetMapping("/attach_vehicle_orders/{id}")
	public OrdersDTO attachedVehicleWithOrder(@PathVariable(value = "id") Long orderId) {
	    
		Long areaId = 1L;
		OrdersDTO orders = orderService.attachedVehicleWithOrder(orderId,areaId,VehicleType.BIKE);
		
		return orders;
	}  
	
	
}
