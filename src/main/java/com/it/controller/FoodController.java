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
import org.springframework.web.bind.annotation.RestController;

import com.it.entity.FoodEntity;
import com.it.model.FoodDto;
import com.it.service.FoodService;

@RestController 
public class FoodController {

	@Autowired
	private FoodService foodser;
	@GetMapping("/Food")
	public List<FoodDto> getAll(){
		return foodser.getAll();
	}
	@GetMapping("/Food/{foodId}")
	public FoodDto getById(@PathVariable Integer foodId) {
		return foodser.getById(foodId);
	}
	
	@PostMapping("/Food")
	public ResponseEntity<?> save(@ModelAttribute FoodDto request)throws IOException{
		foodser.save(request);
		return ResponseEntity.ok("Success");
	}
	@PutMapping("/Food/{foodId}")
	public ResponseEntity<?> update(@PathVariable Integer foodId,@ModelAttribute FoodDto request)throws IOException  {
		foodser.update(foodId, request);
		return ResponseEntity.ok("Success !");
	}
	@DeleteMapping("/Food/{foodId}")
	public void deleteById(@PathVariable Integer foodId) {
		foodser.deleteById(foodId);
	}
	@GetMapping("/Stat")
	public Integer totalpromotion() {
		return foodser.promotiontotal();
	}
	@GetMapping("/random")
	public FoodEntity getRandomFood() {
	    return foodser.getRandomFood();
	}
}
