package com.aungsoe.routingsystem.dao;


import com.aungsoe.routingsystem.domain.Route;

public interface RouteDAO {
 
	Route getRouteByAreaId(Long areaId);
}
