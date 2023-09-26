package com.it.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.it.entity.OrdersEntity;
import com.it.model.OrdersDto;
import com.it.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository orderrsepo;
	
	public List<OrdersDto> getAll(){
		List<OrdersEntity> orderen = orderrsepo.findAll();
		List<OrdersDto> orderdto = null;
		
		if(orderen != null) {
			orderdto = new ArrayList<>();
			for(OrdersEntity ordersojb : orderen) {
				OrdersDto orderdtos = new OrdersDto();
				orderdtos.setOrdersId(ordersojb.getOrdersId());
				orderdtos.setGuestQty(ordersojb.getGuestQty());
				orderdtos.setGuestChild(ordersojb.getGuestChild());
				orderdtos.setTotalGuest(ordersojb.getTotalGuest());
				orderdtos.setGuestPromotion(ordersojb.getGuestPromotion());
				orderdtos.setTotalPrice(ordersojb.getTotalPrice());
				orderdtos.setTableName(ordersojb.getTableName());
				orderdtos.setOrderDate(ordersojb.getOrderDate());
				orderdtos.setOrderStatus(ordersojb.getOrderStatus());
				orderdtos.setSourcesforQr(ordersojb.getSourcesforQr());
				orderdto.add(orderdtos);
			}
		}return orderdto;
	}
	
	
	public OrdersDto getById(Integer ordersId) {
		Optional<OrdersEntity> orderen = orderrsepo.findById(ordersId);
		OrdersDto orderdto = null;
		
		if(orderen.isPresent()) {
			OrdersEntity orderens = orderen.get();
			orderdto = new OrdersDto();
			orderdto.setOrdersId(orderens.getOrdersId());
			orderdto.setGuestQty(orderens.getGuestQty());
			orderdto.setGuestChild(orderens.getGuestChild());
			orderdto.setTotalGuest(orderens.getTotalGuest());
			orderdto.setGuestPromotion(orderens.getGuestPromotion());
			orderdto.setTotalPrice(orderens.getTotalPrice());
			orderdto.setTableName(orderens.getTableName());
			orderdto.setOrderDate(orderens.getOrderDate());
			orderdto.setOrderStatus(orderens.getOrderStatus());
			orderdto.setSourcesforQr(orderens.getSourcesforQr());
			
		}return orderdto;
	}
	
	public OrdersDto save(OrdersDto request) {
	 String	www = "http://localhost:4200/guest/";
		if(request !=null) {
			OrdersEntity orderen = new OrdersEntity();
			orderen.setGuestQty(request.getGuestQty());
			orderen.setGuestChild(request.getGuestChild());
			orderen.setTotalGuest(request.getGuestQty()+request.getGuestChild());
			orderen.setGuestPromotion(request.getGuestPromotion());
			orderen.setTotalPrice((request.getGuestQty()+request.getGuestChild())*request.getGuestPromotion());
			orderen.setTableName(request.getTableName());
			orderen.setOrderDate(new Date());
			orderen.setOrderStatus(1);
			orderen = orderrsepo.save(orderen);
			orderen.setSourcesforQr(www+orderen.getOrdersId());
			 orderrsepo.save(orderen);
			 return convertToDto(orderen);
		} return null;
	}
	
	public void update(Integer ordersId,OrdersDto request) {
		Optional<OrdersEntity> orderen = orderrsepo.findById(ordersId);
		if(orderen.isPresent()) {
			OrdersEntity orderens = orderen.get();
			if(request != null) {
				orderens.setGuestQty(request.getGuestQty());
				orderens.setGuestChild(request.getGuestChild());
				orderens.setTotalGuest(request.getTotalGuest());
				orderens.setGuestPromotion(request.getGuestPromotion());
				orderens.setTotalPrice(request.getTotalPrice());
				orderens.setTableName(request.getTableName());
				orderens.setOrderStatus(request.getOrderStatus());
				orderens.setSourcesforQr(request.getSourcesforQr());
				orderrsepo.save(orderens);
			}
		}
	}
	
	public void deleteById(Integer ordersId) {
		orderrsepo.deleteById(ordersId);
	}
	
	private OrdersDto convertToDto(OrdersEntity entity) {
        OrdersDto dto = new OrdersDto();
        // ทำการแปลงข้อมูลจาก entity ไปยัง DTO
        dto.setOrdersId(entity.getOrdersId());
        dto.setGuestQty(entity.getGuestQty());
        dto.setGuestChild(entity.getGuestChild());
        dto.setTotalGuest(entity.getTotalGuest());
        dto.setGuestPromotion(entity.getGuestPromotion());
        dto.setTotalPrice(entity.getTotalPrice());
        dto.setTableName(entity.getTableName());
        dto.setOrderDate(entity.getOrderDate());
        dto.setOrderStatus(entity.getOrderStatus());
        
        // ... แปลงข้อมูลอื่น ๆ ตามที่ต้องการ
        return dto;
    }
}
