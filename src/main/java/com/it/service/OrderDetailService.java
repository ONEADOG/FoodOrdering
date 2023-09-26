package com.it.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.OrderDetailEntity;
import com.it.model.OrderDetailDto;
import com.it.repository.OrderDetailRepository;

@Service
public class OrderDetailService {

	
	@Autowired
	private OrderDetailRepository orderDrepo;
	
	public List<OrderDetailDto> getAll(){
		List<OrderDetailEntity> orderden = orderDrepo.findAll();
		List<OrderDetailDto> orderes = null;
		if(orderden != null) {
			orderes = new ArrayList<>();
			for(OrderDetailEntity orderojb : orderden) {
			OrderDetailDto	orderres = new OrderDetailDto();
			orderres.setOrderId(orderojb.getOrderId());
			orderres.setOrderDesc(orderojb.getOrderDesc());
			orderres.setOrderQty(orderojb.getOrderQty());
			orderres.setOrderComment(orderojb.getOrderComment());
			orderres.setTableName(orderojb.getTableName());
			orderres.setOrderDate(orderojb.getOrderDate());
			orderres.setOrderStatus(orderojb.getOrderStatus());
			orderes.add(orderres);
			}
		}return orderes;
	}
	
	public OrderDetailDto getById(Integer orderId) {
		Optional<OrderDetailEntity> orderen = orderDrepo.findById(orderId);
		OrderDetailDto orderres = null;
		if(orderen.isPresent()) {
			OrderDetailEntity orderren = orderen.get();
			orderres = new  OrderDetailDto();
			orderres.setOrderId(orderren.getOrderId());
			orderres.setOrderDesc(orderren.getOrderComment());
			orderres.setOrderQty(orderren.getOrderQty());
			orderres.setOrderComment(orderren.getOrderComment());
			orderres.setOrderDate(orderren.getOrderDate());
			orderres.setTableName(orderren.getTableName());
			orderres.setOrderStatus(orderren.getOrderStatus());
		}return orderres;
	}
	public void save(OrderDetailDto request) {
		if(request != null) {
			OrderDetailEntity orderen = new OrderDetailEntity();
			orderen.setOrderDesc(request.getOrderDesc());
			orderen.setOrderQty(request.getOrderQty());
			orderen.setOrderComment(request.getOrderComment());
			orderen.setTableName(request.getTableName());
			orderen.setOrderDate(new Date());
			orderen.setOrderStatus(1);
			orderDrepo.save(orderen);
		}
	}
	public void update(Integer orderId,OrderDetailDto request) {
		Optional<OrderDetailEntity> orderen = orderDrepo.findById(orderId);
		if(orderen.isPresent()) {
			OrderDetailEntity orderren = orderen.get();
			if(request != null) {
				orderren.setOrderDesc(request.getOrderDesc());
				orderren.setOrderQty(request.getOrderQty());
				orderren.setOrderComment(request.getOrderComment());
				orderren.setTableName(request.getTableName());
				orderren.setOrderStatus(request.getOrderStatus());
				
			}orderDrepo.save(orderren);
		}
	}
	public void deleteById(Integer orderId) {
		orderDrepo.deleteById(orderId);
	}
}
