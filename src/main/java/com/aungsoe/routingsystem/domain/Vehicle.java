package com.aungsoe.routingsystem.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable{

	private static final long serialVersionUID = -5095296564495822754L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id",nullable = false)
	private Long vehicleId; 
	
	@Column(name = "max_order_capacity",nullable = false)
	private Long maxOrderCapacity;
	
	@Column(name = "vehicle_type",nullable = false)
	private String vehicleType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="route_id", nullable=false)
	private Route route;

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getMaxOrderCapacity() {
		return maxOrderCapacity;
	}

	public void setMaxOrderCapacity(Long maxOrderCapacity) {
		this.maxOrderCapacity = maxOrderCapacity;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	
}
