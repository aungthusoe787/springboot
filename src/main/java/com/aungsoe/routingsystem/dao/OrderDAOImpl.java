package com.aungsoe.routingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aungsoe.routingsystem.domain.Orders;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	private EntityManager entityManager;
	 
	@Override
	public List<Orders> getOrderAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Query<Orders> query = currentSession.createQuery("from Orders", Orders.class);
		List<Orders> orderList = query.getResultList();
		return orderList;
	}

	@Override
	public Orders getById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Orders orders = currentSession.get(Orders.class, id);
		return orders;
	}

}
