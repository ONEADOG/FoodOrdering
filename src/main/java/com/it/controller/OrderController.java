package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.Ordermodel;
import com.it.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private  OrderService orderser;
	
	@GetMapping("order")
	public List<Ordermodel> getAll(){
		return orderser.getAll();
	}
	@GetMapping("order/{orderId}")
	public Ordermodel getById(@PathVariable Integer orderId) {
		return orderser.getById(orderId);
	}
	@PostMapping("order")
	public void save(@RequestBody Ordermodel request) {
		orderser.save(request);
	}
	@PutMapping("order/{orderId}")
	public void update(@PathVariable Integer orderId,@RequestBody Ordermodel request) {
		orderser.update(orderId, request);
	}
	@DeleteMapping("order/{orderId}")
	public void deleteById(@PathVariable Integer orderId) {
		orderser.deleteById(orderId);
	}
	@GetMapping("getorder")
	public List<Ordermodel> getByTableName(@RequestParam(name="tableName") String tableName){
		return orderser.findOrderByTableName(tableName);
	}
	@GetMapping("getorder/{ordersId}")
	public List<Ordermodel> getByOrdersId(@PathVariable(name="ordersId") Integer ordersId){
		return orderser.findOrderByOrdersId(ordersId);
	}
}
