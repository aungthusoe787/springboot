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
@Table(name = "orders")
public class Orders implements Serializable{
	
	private static final long serialVersionUID = 3817906315154301752L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id",nullable = false)
	private Long orderId;
	
	@Column(name = "product_id",nullable = false)
	private Long productId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="area_id", nullable=false)
	private AreaList areaList;
	
	@Column(name = "vehicle_type",nullable = false)
	private String vehicleType;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public AreaList getAreaList() {
		return areaList;
	}

	public void setAreaList(AreaList areaList) {
		this.areaList = areaList;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	

}
