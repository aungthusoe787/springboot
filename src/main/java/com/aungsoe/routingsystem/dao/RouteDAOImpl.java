package com.aungsoe.routingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aungsoe.routingsystem.domain.Route;

@Repository("routeDAO")
public class RouteDAOImpl implements RouteDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Route getRouteByAreaId(Long areaId) {
		Session currentSession = entityManager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Criteria c = currentSession.createCriteria(Route.class)
						.createAlias("areaList", "areaList", JoinType.LEFT_OUTER_JOIN);
		
		c.add(Restrictions.eq("areaList.areaId", areaId));	
		
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Route> list = c.list();
		
		if (list.size() > 0) {
			return list.get(0);
		}
		else {
			return null;
		}
	}

}
