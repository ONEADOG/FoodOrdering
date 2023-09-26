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

import com.it.model.FoodTypeDto;
import com.it.service.FoodTypeService;



@RestController
public class FoodTypeController {
@Autowired
private FoodTypeService foodtypeser;

@GetMapping("/foodtype")
public List<FoodTypeDto> getTypeAll(){
	return foodtypeser.getAll();
}
@GetMapping("/foodtype/{typeId}")
public FoodTypeDto getTypeById(@PathVariable Integer typeId) {
	return foodtypeser.getTypeById(typeId);
}
@PostMapping("/foodtype")
public void saveType(@RequestBody FoodTypeDto request){
	foodtypeser.saveType(request);
}
@PutMapping("/foodtype/{typeId}")
public void update(@PathVariable Integer typeId,@RequestBody FoodTypeDto request) {
	foodtypeser.update(typeId, request);
}
@DeleteMapping("/foodtype/{typeId}")
public void deleteById(@PathVariable Integer typeId) {
	foodtypeser.deleteById(typeId);
}
}
