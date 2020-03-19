package com.aungsoe.routingsystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aungsoe.routingsystem.domain.Orders;
import com.aungsoe.routingsystem.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order_list")
	public String viewOrderList(Model model) {
		System.out.println("View Orders List in Controller");
	    List<Orders> listProducts = orderService.getOrderAll();
	    model.addAttribute("listOrders", listProducts);
	     
	    return "order_list";
	}
	
	@GetMapping("/order_detail/{id}")
	public ModelAndView orderDetails(@PathVariable(name = "id") Long id) {
		System.out.println("Order Details in Controller");
		ModelAndView mav = new ModelAndView("order_details");

		Orders orders = orderService.getById(id);
	    mav.addObject("orders", orders);
	     
	    return mav;
	}
	
	

}
