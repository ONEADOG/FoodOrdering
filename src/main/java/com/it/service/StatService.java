package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.repository.OrderRepository;
import com.it.repository.PaymentRepository;
import com.it.repository.TestRepository;
import com.it.repository.TestregisterRepository;

@Service
public class StatService {

	@Autowired
	private PaymentRepository paymentrepo;
	@Autowired
	private OrderRepository orderrepo;
	@Autowired
	private TestRepository testrepo;
	
	public Integer total() {
		return paymentrepo.total();
	}
	
	public Integer totalguest() {
		return paymentrepo.totalguest();
	}
	
	public List<Object[]> getTop3PopularKeywords() {
		return testrepo.findTop3PopularKeywords();
	}
}
