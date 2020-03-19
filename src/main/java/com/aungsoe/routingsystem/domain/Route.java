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
@Table(name = "route")
public class Route implements Serializable{

	private static final long serialVersionUID = 7208736885513086950L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id",nullable = false)
	private Long routeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="area_id", nullable=false)
	private AreaList areaList;
	
	@Column(name = "sequence",nullable = false)
	private Long sequence;

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	
	public AreaList getAreaList() {
		return areaList;
	}

	public void setAreaList(AreaList areaList) {
		this.areaList = areaList;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	
}
