package com.it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.FoodTypeEntity;

import com.it.model.FoodTypeDto;
import com.it.repository.FoodtypeRepository;

@Service
public class FoodTypeService {

	@Autowired
	private FoodtypeRepository foodtyperepo;
	
	public List<FoodTypeDto> getAll(){
		List<FoodTypeEntity> foodten = foodtyperepo.findAll();
		List<FoodTypeDto> fooddto = null;
		if(foodten != null) {
			  fooddto = new ArrayList<>();
			for(FoodTypeEntity foodtojb : foodten) {
				 FoodTypeDto foodtyp = new FoodTypeDto();
				 foodtyp.setTyprId(foodtojb.getTypeId());
				 foodtyp.setFoodType(foodtojb.getFoodType());
				 foodtyp.setTypeStatus(foodtojb.getTypeStatus());
				 fooddto.add(foodtyp);
			}
			}return fooddto;
	}
	
	public FoodTypeDto getTypeById(Integer typeId) {
		Optional<FoodTypeEntity> foodtypen = foodtyperepo.findById(typeId);
		FoodTypeDto foodtdto = null;
		if(foodtypen.isPresent()) {
			FoodTypeEntity foodten = foodtypen.get();
			foodtdto = new FoodTypeDto();
			foodtdto.setTyprId(foodten.getTypeId());
			foodtdto.setFoodType(foodten.getFoodType());
			foodtdto.setTypeStatus(foodten.getTypeStatus());
		}return foodtdto;
	}
	
	public void saveType(FoodTypeDto request) {
		if(request !=null) {
			FoodTypeEntity foodten =  new FoodTypeEntity();
			foodten.setFoodType(request.getFoodType());
			foodten.setTypeStatus(1);
			foodtyperepo.save(foodten);
		}
	}
	public void update(Integer typeId,FoodTypeDto request) {
		Optional<FoodTypeEntity> foodten = foodtyperepo.findById(typeId);
		if(foodten.isPresent()) {
			FoodTypeEntity foodte = foodten.get();
			if(request != null) {
				foodte.setFoodType(request.getFoodType());
				foodte.setTypeStatus(request.getTypeStatus());
				foodtyperepo.save(foodte);
			}
		}
	}
	public void deleteById(Integer typeId) {
		foodtyperepo.deleteById(typeId);
	}
}
