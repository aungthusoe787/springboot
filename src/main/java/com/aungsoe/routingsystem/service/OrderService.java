package com.aungsoe.routingsystem.service;

import java.util.List;

import com.aungsoe.routingsystem.bean.OrdersDTO;
import com.aungsoe.routingsystem.domain.Orders;
import com.aungsoe.routingsystem.util.CommonConstant.VehicleType;

public interface OrderService {

	List<Orders> getOrderAll();
	
	Orders getById(Long id);
	
	OrdersDTO attachedVehicleWithOrder(Long orderId,Long areaId,VehicleType vehicleType);	

	List<OrdersDTO> attachedVehicleWithAllOrders(List<Orders> ordersList);

}
