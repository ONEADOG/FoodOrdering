package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.service.StatService;

@RestController
public class StatController {

	@Autowired
	private StatService statser;
	
	@GetMapping("/gettotal")
	public Integer getTotal() {
		return statser.total();
	} 
	@GetMapping("/gettotalguest")
	public Integer totalGuest() {
		return statser.totalguest();
	}
	@GetMapping("/getpopular")
	public List<Object[]> getTop3PopularKeywords() {
		return statser.getTop3PopularKeywords();
	}
}
