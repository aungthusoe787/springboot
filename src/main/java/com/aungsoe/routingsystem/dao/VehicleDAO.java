package com.aungsoe.routingsystem.dao;

import java.util.List;

import com.aungsoe.routingsystem.domain.Vehicle;

public interface VehicleDAO {

	Vehicle getVehicleById(Long id);
	
	List<Vehicle> getVehicleByRouteIdAndType(Long routeId,String vehicleType);
}
