package com.aungsoe.routingsystem.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area_list")
public class AreaList implements Serializable {

	private static final long serialVersionUID = -4308982128133657234L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id",nullable = false)
	private Long areaId;
	
	@Column(name = "area_name",nullable = false)
	private String areaName;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
