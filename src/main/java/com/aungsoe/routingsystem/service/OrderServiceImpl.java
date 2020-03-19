package com.aungsoe.routingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aungsoe.routingsystem.bean.OrdersDTO;
import com.aungsoe.routingsystem.dao.OrderDAO;
import com.aungsoe.routingsystem.dao.RouteDAO;
import com.aungsoe.routingsystem.dao.VehicleDAO;
import com.aungsoe.routingsystem.domain.Orders;
import com.aungsoe.routingsystem.domain.Route;
import com.aungsoe.routingsystem.domain.Vehicle;
import com.aungsoe.routingsystem.util.CommonConstant;
import com.aungsoe.routingsystem.util.CommonConstant.VehicleType;

@Transactional(propagation=Propagation.REQUIRED)
@Service("OrderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private VehicleDAO vehicleDao;
	
	@Autowired
	private RouteDAO routeDao;
	
	@Override
	public List<Orders> getOrderAll() {
		return orderDao.getOrderAll();
	}

	@Override
	public Orders getById(Long id) {
		return orderDao.getById(id);
	}
	
	@Override
	public List<OrdersDTO> attachedVehicleWithAllOrders(List<Orders> ordersList){
		List<OrdersDTO> ordersDTOList = new ArrayList<OrdersDTO>();
		
		if(ordersList != null && ordersList.size() > 0) {
			System.out.println("Orders Size :"+ordersList.size());
			for(Orders o: ordersList) {
				Long orderId = o.getOrderId();
				String vType = o.getVehicleType();
				Long areaId = o.getAreaList().getAreaId();
				OrdersDTO ordersDTO = attachedVehicleWithOrder(orderId, areaId,
						vType.equals(VehicleType.BIKE.getType())? VehicleType.BIKE : VehicleType.VAN);
			
				ordersDTOList.add(ordersDTO);
			}
		}
	
		return ordersDTOList;
	}
	
	@Override
	public OrdersDTO attachedVehicleWithOrder(Long orderId,Long areaId,VehicleType vehicleType) {
		
		Route route = routeDao.getRouteByAreaId(areaId);
		//check vehicle type
		List<Vehicle> vehicleList = vehicleDao.getVehicleByRouteIdAndType(route.getRouteId(), vehicleType.getType());
		
		Vehicle vehicle = null;
		if(vehicleList != null && vehicleList.size() > 0) {
			vehicle = getVehicleByList(vehicleList,areaId);
		}
		
		if(vehicle == null) {
			if(CommonConstant.VehicleType.BIKE.equals(vehicleType)) {
				//get vehicle van if bike order is full
				List<Vehicle> vehicleVanList = vehicleDao.getVehicleByRouteIdAndType(route.getRouteId(), CommonConstant.VehicleType.VAN.getType());
				vehicle = getVehicleByList(vehicleVanList,areaId);
			}else {
				//get vehicle bike if van order is full
				List<Vehicle> vehicleBikeList = vehicleDao.getVehicleByRouteIdAndType(route.getRouteId(), CommonConstant.VehicleType.BIKE.getType());
				vehicle = getVehicleByList(vehicleBikeList,areaId);
			}
		}
		
		if(vehicle != null) {
			System.out.println("vehicle id :"+vehicle.getVehicleId());
			System.out.println("max order vehicle :"+vehicle.getMaxOrderCapacity());
			System.out.println("vehicle type :"+vehicle.getVehicleType());
			
			Orders orders = orderDao.getById(orderId);
			OrdersDTO ordersDTO = new OrdersDTO(orders.getOrderId(),
					orders.getProductId(),orders.getAreaList().getAreaName(),vehicle.getVehicleId());
			
			return ordersDTO;
		}else {
			System.out.println("all vehicle is full orders");
			return null;
		}
		
	}
	
	
	
	private Vehicle getVehicleByList(List<Vehicle> vehicleList,Long orderAreaId) {
		Vehicle vehicle = null;
		for(Vehicle v:vehicleList) {
			Long vehicleAreaId = v.getRoute().getAreaList().getAreaId();
			if(v.getMaxOrderCapacity() > 0 && orderAreaId.equals(vehicleAreaId)) { // check max Order capacity , area
				vehicle = v;
				break;
			}
		}
		
		return vehicle;
	}

}
