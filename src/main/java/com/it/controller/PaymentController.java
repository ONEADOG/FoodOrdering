package com.it.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.entity.PaymentEntity;
import com.it.model.PaymentDto;
import com.it.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService payser;
	
	@GetMapping("/Payment")
	public List<PaymentDto> getAll(){
		return payser.getAll();
	}
	
	@GetMapping("/Payment/{paymentId}")
	public PaymentDto getById(@PathVariable Integer paymentId) {
		return payser.getById(paymentId);
	}
	
	@GetMapping("Paymentt")
	public PaymentDto getPaymentByTableName(@RequestParam(name="tableName") String tableName ) {
		return payser.getByTableName(tableName);
		 
	}
	@PostMapping("/Payment")
	public ResponseEntity<?> save(@ModelAttribute PaymentDto request) throws  IOException {
		payser.save(request);
		return ResponseEntity.ok("Success!?"); 
	}
	
	@PutMapping("/Payment/{paymentId}")
	public void Update(@PathVariable Integer paymentId,@ModelAttribute PaymentDto request) throws  IOException {
		payser.update(paymentId, request);
		ResponseEntity.ok("Success!?");
	}
	@DeleteMapping("/Payment/{paymentId}")
	public void deleteById(Integer paymentId) {
		payser.deleteById(paymentId);
	}
	@GetMapping("/Payments/{ordersId}")
	public PaymentDto findByOrdersId(@PathVariable(name="ordersId") Integer ordersId ) {
		return payser.getByOrdersId(ordersId);
	}
	
//	@GetMapping("/Payment")
//	public List<E>
}
