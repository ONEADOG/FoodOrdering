package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.OrderDetailDto;
import com.it.service.OrderDetailService;

@RestController
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDser;
	
	@GetMapping("/OrderDetail")
	public List<OrderDetailDto> getAll(){
		return orderDser.getAll();
	}
	
	@GetMapping("/OrderDetail/{orderId}")
	public OrderDetailDto getById(@PathVariable Integer orderId) {
		return orderDser.getById(orderId);
	}
	@PostMapping("/OrderDetail")
	public void save(@RequestBody OrderDetailDto request) {
		orderDser.save(request);
		
	}
	@PutMapping("/OrderDetail/{orderId}")
	public void updateById(@PathVariable Integer orderId,@RequestBody OrderDetailDto requset) {
		orderDser.update(orderId, requset);
	}
	@DeleteMapping("/OrderDetail/{orderId}")
	public void deleteById(@PathVariable Integer orderId) {
		orderDser.deleteById(orderId);
	}
}
