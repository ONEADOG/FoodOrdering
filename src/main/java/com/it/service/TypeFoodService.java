package com.it.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.FoodEntity;
import com.it.model.FoodDto;
import com.it.repository.TypefoodRepository;

@Service
public class TypeFoodService {

	@Autowired 
	private TypefoodRepository typefood;
	
	public List<FoodDto> getAllType(){
		List<FoodEntity> fooden = typefood.findAll();
		List<FoodDto> fooddto = null;
		if(fooden != null) {
		  fooddto = new ArrayList<>();
		  for(FoodEntity foodojb: fooden) {
			  FoodDto foodres = new FoodDto();
			  foodres.setFoodId(foodojb.getFoodId());
			  foodres.setFoodName(foodojb.getFoodName());
			  foodres.setFoodQty(foodojb.getFoodQty());
			  foodres.setFoodType(foodojb.getFoodType());
			  foodres.setPromotion(foodojb.getPromotion());
			  foodres.setFoodStatus(foodojb.getFoodStatus());
			  foodres.setFoodImage(foodojb.getFoodImage());
			  fooddto.add(foodres);
		  }
		}return fooddto;
	}
	
//	public  FoodDto getfoodByType(FoodDto foodType) {
//		Optional<FoodEntity > fooden = typefood.findByType(foodType);  
//	}
}
