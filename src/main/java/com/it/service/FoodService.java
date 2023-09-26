 package com.it.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.it.entity.FoodEntity;
import com.it.model.FoodDto;
import com.it.repository.FoodRepository;
import com.it.repository.StatRepository;

@Service 
public class FoodService {

	@Autowired
	private FoodRepository foodrepo;
	@Autowired
	private StatRepository statrepo;
	
	public List<FoodDto> getAll(){
		List<FoodEntity> fooden = foodrepo.findAll();
		List<FoodDto> foodre = null;
		
		if(fooden != null) {
			foodre = new ArrayList<>();
			for(FoodEntity foodojb : fooden) {
				FoodDto foodes = new FoodDto();
				foodes.setFoodId(foodojb.getFoodId());
				foodes.setFoodImage(foodojb.getFoodImage());
				foodes.setFoodName(foodojb.getFoodName());
				foodes.setFoodQty(foodojb.getFoodQty());
				foodes.setFoodType(foodojb.getFoodType());
				foodes.setPromotion(foodojb.getPromotion());
				foodes.setFoodStatus(foodojb.getFoodStatus());
				foodre.add(foodes);
			}
		}return foodre;	
	}
	public FoodDto getById(Integer foodId) {
		Optional<FoodEntity> fooden = foodrepo.findById(foodId);
		FoodDto foodre  = null;
		
		if(fooden.isPresent()) {
			FoodEntity foode = fooden.get();
			foodre = new FoodDto();
			foodre.setFoodId(foode.getFoodId());
			foodre.setFoodImage(foode.getFoodImage());
			foodre.setFoodName(foode.getFoodName());
			foodre.setFoodQty(foode.getFoodQty());
			foodre.setFoodType(foode.getFoodType());
			foodre.setPromotion(foode.getPromotion());
			foodre.setFoodStatus(foode.getFoodStatus());
			
			
		}return foodre;
	}
	public void save(FoodDto request) throws IOException{
		MultipartFile file = request.getFile();
		
		if(request != null) {
			FoodEntity fooden = new FoodEntity();
			fooden.setFoodName(request.getFoodName());
			fooden.setFoodQty(request.getFoodQty());
			fooden.setFoodType(request.getFoodType());
			fooden.setPromotion(request.getPromotion());
			fooden.setFoodStatus(1);
			if(file != null ) {
				String filename = file.getOriginalFilename();
				String filepath = "D:\\ProjectFontend\\fontendproject\\src\\assets\\image\\Food/"+filename;
				String finalpath = "assets"+"/image/Food/"+filename;
				Path pathfile = Path.of(filepath);
				Files.copy(file.getInputStream(), pathfile, StandardCopyOption.REPLACE_EXISTING);
				
				fooden.setFoodImage(finalpath);
			}
			foodrepo.save(fooden);
		}
	}
	
	public void update(Integer foodId, FoodDto request) throws IOException{
		Optional<FoodEntity> fooden = foodrepo.findById(foodId);
		MultipartFile file = request.getFile();
		if(fooden.isPresent()) {
			FoodEntity foodentity = fooden.get();
			if(request != null) {
				if(file != null && !file.isEmpty()) {
					String filename = file.getOriginalFilename();
					String filepath = "D:\\ProjectFontend\\fontendproject\\src\\assets\\image\\Food/"+filename;
					String finalpath = "assets"+"/image/Food/"+filename;
					
					Path pathfile = Path.of(filepath);
					Files.copy(file.getInputStream(), pathfile, StandardCopyOption.REPLACE_EXISTING);
					
					foodentity.setFoodImage(finalpath);	}
				foodentity.setFoodName(request.getFoodName());
				foodentity.setFoodQty(request.getFoodQty());
				foodentity.setFoodType(request.getFoodType());
				foodentity.setFoodStatus(request.getFoodStatus());
			
				foodrepo.save(foodentity);
		}
		}
		
	}
	
	public void deleteById(Integer foodId) {
		foodrepo.deleteById(foodId);
	}
	public Integer promotiontotal() {
		return statrepo.totalpromotion();
	}
	
	 public FoodEntity getRandomFood() {
	        List<FoodEntity> allFood = foodrepo.findAll();
	        if (!allFood.isEmpty()) {
	            Random random = new Random();
	            int randomIndex = random.nextInt(allFood.size());
	            return allFood.get(randomIndex);
	        }
	        return null;
	    }
}
