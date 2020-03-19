package com.aungsoe.routingsystem.dao;
import java.util.List;

import com.aungsoe.routingsystem.domain.Orders;

public interface OrderDAO {

	List<Orders> getOrderAll();
	
	Orders getById(Long id);
}
