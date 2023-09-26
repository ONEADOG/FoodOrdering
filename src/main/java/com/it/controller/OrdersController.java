package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.OrdersDto;
import com.it.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersser;
	
	@GetMapping("/orders")
	public List<OrdersDto> getAll(){
		return ordersser.getAll();
	}
	
	@GetMapping("/orders/{ordersId}")
	public OrdersDto getById(@PathVariable Integer ordersId) {
		return ordersser.getById(ordersId);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<OrdersDto> save(@RequestBody OrdersDto request) {
		OrdersDto saveOrder = ordersser.save(request);
		return ResponseEntity.ok(saveOrder);
	}
	
	@PutMapping("/orders/{ordersId}")
	public void update(@PathVariable Integer ordersId,@RequestBody OrdersDto request) {
		ordersser.update(ordersId, request);
	}
	
	@DeleteMapping("/orders/{ordersId}")
	public void deleteById(@PathVariable Integer ordersId) {
		ordersser.deleteById(ordersId);
	}
}
