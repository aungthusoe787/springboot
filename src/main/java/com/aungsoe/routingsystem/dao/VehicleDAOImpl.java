package com.aungsoe.routingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aungsoe.routingsystem.domain.Vehicle;

@Repository("vehicleDAO")
public class VehicleDAOImpl implements VehicleDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Vehicle getVehicleById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Vehicle vehicle = currentSession.get(Vehicle.class, id);
		return vehicle;
	}

	@Override
	public List<Vehicle> getVehicleByRouteIdAndType(Long routeId, String vehicleType) {
		Session currentSession = entityManager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Criteria c = currentSession.createCriteria(Vehicle.class)
						.createAlias("route", "route", JoinType.LEFT_OUTER_JOIN);
		
		c.add(Restrictions.eq("route.routeId", routeId));	
		c.add(Restrictions.eq("vehicleType", vehicleType));	
		
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Vehicle> list = c.list();
		
		return list;
	}

}
