package com.it.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.OrderEntity;
import com.it.model.Ordermodel;
import com.it.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderrepo;
	
	public List<Ordermodel> getAll(){
		List<OrderEntity> orderen = orderrepo.findAll();
		List<Ordermodel> orderdto = null;
		if(orderen != null) {
		orderdto = new ArrayList<>(); 
		for(OrderEntity orderojb : orderen) {
			Ordermodel ordere = new Ordermodel();
			ordere.setOrderId(orderojb.getOrderId());
			ordere.setOrderDetail(orderojb.getOrderDetail());
			ordere.setTableName(orderojb.getTableName());
			ordere.setOrderDate(orderojb.getOrderDate());
			ordere.setOrderStatus(orderojb.getOrderStatus());
			ordere.setOrderQty(orderojb.getOrderQty());
			ordere.setOrderNote(orderojb.getOrderNote());
			ordere.setOrdersId(orderojb.getOrdersId());
			orderdto.add(ordere);
		}
		}return orderdto;
	}
	
	public Ordermodel getById(Integer orderId) {
	Optional<OrderEntity> ordern = orderrepo.findById(orderId);
	Ordermodel ordermo = null;
	
		if(ordern.isPresent()){
			OrderEntity ordere = ordern.get();
			ordermo = new Ordermodel();
			ordermo.setOrderId(ordere.getOrderId());
			ordermo.setOrderDetail(ordere.getOrderDetail());
			ordermo.setTableName(ordere.getTableName());
			ordermo.setOrderDate(ordere.getOrderDate());
			ordermo.setOrderStatus(ordere.getOrderStatus());
			ordermo.setOrderNote(ordere.getOrderNote());
			ordermo.setOrderQty(ordere.getOrderQty());
			ordermo.setOrdersId(ordere.getOrdersId());
		}return ordermo;
	}
	public void save(Ordermodel request) {
		if(request !=null) {
			OrderEntity ordern = new OrderEntity();
			ordern.setOrderDetail(request.getOrderDetail());
			ordern.setTableName(request.getTableName());
			ordern.setOrderStatus(1);
			ordern.setOrderQty(request.getOrderQty());
			ordern.setOrderDate(new Date());
			ordern.setOrdersId(request.getOrdersId());
			orderrepo.save(ordern);
		}
	}
	public void update(Integer orderId,Ordermodel request) {
		Optional<OrderEntity> ordern = orderrepo.findById(orderId);
		if(ordern.isPresent()) {
			OrderEntity ordere = ordern.get();
			if(request !=null) {
				ordere.setOrderDetail(request.getOrderDetail());
				ordere.setTableName(request.getTableName());
				ordere.setTableName(request.getTableName());
				ordere.setOrderNote(request.getOrderNote());
				ordere.setOrderQty(request.getOrderQty());
				ordere.setOrderStatus(request.getOrderStatus());
				ordere.setOrdersId(request.getOrdersId());
				orderrepo.save(ordere);
			}
		}
	}
	public void deleteById(Integer orderId) {
		orderrepo.deleteById(orderId);
	}
	
	public List<Ordermodel> findOrderByTableName(String tableName) {
		List<OrderEntity> orderEn = orderrepo.findByTableName(tableName);
		List<Ordermodel> orderres = null;
		
		if(orderEn != null) {
			 orderres = new ArrayList<>(); 
			for(OrderEntity  orderojb :orderEn) {
				Ordermodel orderre = new Ordermodel();
				orderre.setOrderId(orderojb.getOrderId());
				orderre.setTableName(orderojb.getTableName());
				orderre.setOrderDetail(orderojb.getOrderDetail());
				orderre.setOrderDate(orderojb.getOrderDate());
				orderre.setOrderQty(orderojb.getOrderQty());
				orderre.setOrderNote(orderojb.getOrderNote());
				orderre.setOrderStatus(orderojb.getOrderStatus());
				orderres.add(orderre);
			}
		}return orderres;
	}
	public List<Ordermodel> findOrderByOrdersId(Integer ordersId) {
		List<OrderEntity> orderEn = orderrepo.findByordersId(ordersId);
		List<Ordermodel> orderres = null;
		
		if(orderEn != null) {
			 orderres = new ArrayList<>(); 
			for(OrderEntity  orderojb :orderEn) {
				Ordermodel orderre = new Ordermodel();
				orderre.setOrderId(orderojb.getOrderId());
				orderre.setTableName(orderojb.getTableName());
				orderre.setOrderDetail(orderojb.getOrderDetail());
				orderre.setOrderDate(orderojb.getOrderDate());
				orderre.setOrderQty(orderojb.getOrderQty());
				orderre.setOrderNote(orderojb.getOrderNote());
				orderre.setOrderStatus(orderojb.getOrderStatus());
				orderre.setOrdersId(orderojb.getOrdersId());
				orderres.add(orderre);
			}
		}return orderres;
	}
}
