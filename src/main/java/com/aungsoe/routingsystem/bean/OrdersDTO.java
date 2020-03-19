package com.aungsoe.routingsystem.bean;

public class OrdersDTO {

	private Long orderId;
	private Long productId;
	private String areaName;
	private Long vehicleId;
	
	public OrdersDTO() {
	}
	
	public OrdersDTO(Long orderId,Long productId,String areaName,Long vehicleId) {
		this.orderId = orderId;
		this.productId = productId;
		this.areaName = areaName;
		this.vehicleId = vehicleId;
	}
	
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
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
}
