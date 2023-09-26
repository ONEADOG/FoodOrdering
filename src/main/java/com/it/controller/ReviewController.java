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

import com.it.model.ReviewDto;
import com.it.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewser;
	@GetMapping("/review")
	public List<ReviewDto> getAll(){
		return reviewser.getAll();
	}
	@GetMapping("/review/{reviewId}")
	public ReviewDto getById(@PathVariable Integer reviewId) {
	return	reviewser.getById(reviewId);
	}
	@PostMapping("/review")
	public void save(@RequestBody ReviewDto request ) {
		reviewser.save(request);
	}
	@PutMapping("/review/{reviewId}")
	public void update(@PathVariable Integer reviewId,@RequestBody ReviewDto request) {
		reviewser.update(reviewId, request);
	}
	@DeleteMapping("/review/{reviewId}")
	public void deleteById(@PathVariable Integer reviewId) {
		reviewser.deleteById(reviewId);
	}
}
