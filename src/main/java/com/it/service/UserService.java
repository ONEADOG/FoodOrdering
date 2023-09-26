package com.it.service;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



//import com.it.entity.LoginEntity;
import com.it.entity.UserEntity;
//import com.it.model.RegisterDto;
import com.it.model.UserDto;
//import com.it.repository.LoginRepository;
import com.it.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepo;

	
	public List<UserDto> getAll(){
		List<UserEntity> useren = userrepo.findAll();
		List<UserDto> userd = null;
		if(useren != null) {
			userd = new ArrayList<>();
			for(UserEntity userojb : useren) {
				UserDto userdto = new UserDto();
				userdto.setUserId(userojb.getUserId());
				userdto.setFirstName(userojb.getFirstName());
				userdto.setLastName(userojb.getLastName());
				userdto.setUserAge(userojb.getUserAge());
				userdto.setUserPhone(userojb.getUserPhone());
				userdto.setUserImage(userojb.getUserImage());
				userdto.setUserDate(userojb.getUserDate());
				userdto.setUserType(userojb.getUserType());
				userdto.setUserStatus(userojb.getUserStatus());
				userd.add(userdto);
			}
		}return userd;
	}
	public UserDto getById(Integer userId) {
		Optional<UserEntity > useren = userrepo.findById(userId);
		UserDto userdto = null;
		if(useren.isPresent()) {
		UserEntity	usere =  useren.get();
		userdto = new UserDto();
		userdto.setUserId(usere.getUserId());
		userdto.setFirstName(usere.getFirstName());
		userdto.setLastName(usere.getLastName());
		userdto.setUserAge(usere.getUserAge());
		userdto.setUserPhone(usere.getUserPhone());
		userdto.setUserImage(usere.getUserImage());
		userdto.setUserDate(usere.getUserDate());
		userdto.setUserType(usere.getUserType());
		userdto.setUserStatus(usere.getUserStatus());
		}return userdto;
	} 
	
	public void save(UserDto request) {
		if(request != null) {
			UserEntity useren = new UserEntity();
			useren.setFirstName(request.getFirstName());
			useren.setLastName(request.getLastName());
			useren.setUserAge(request.getUserAge());
			useren.setUserPhone(request.getUserPhone());
			useren.setUserType(request.getUserType());
			useren.setUserDate(new Date());
			useren.setUserImage("ทดสอบ");
			useren.setUserStatus(1);
			userrepo.save(useren);
			
		}		


	}
	
	
	public void update(UserDto request, Integer userId) {
		Optional<UserEntity> useren = userrepo.findById(userId);
		if(useren.isPresent()) {
			UserEntity usere = useren.get();
			if(request != null) {	
				usere.setFirstName(request.getFirstName());
				usere.setLastName(request.getLastName());
				usere.setUserAge(request.getUserAge());
				usere.setUserPhone(request.getUserPhone());
				usere.setUserImage("ทดสอบ");
				usere.setUserType(request.getUserType());
				usere.setUserStatus(request.getUserStatus());
				userrepo.save(usere);
			}
			
		}
	}
	
	public void deleteById(Integer userId) {
		userrepo.deleteById(userId);
	}
	
	public List<UserDto> findByDate(UserDto searchDate){
		Date strDate = searchDate.getStrDate();
		Date endDate = searchDate.getEndDate();
		List<UserEntity> userren = userrepo.findDateBetweenDate(strDate, endDate);
		List<UserDto> userdto = null;	
		if(!userren.isEmpty()) { 
			userdto = new ArrayList<>();
		for(UserEntity userojb : userren) {
			UserDto userdt = new UserDto();
			userdt.setFirstName(userojb.getFirstName());
			userdt.setLastName(userojb.getLastName());
			userdt.setUserAge(userojb.getUserAge());
			userdt.setUserPhone(userojb.getUserPhone());
			userdt.setUserType(userojb.getUserType());
			userdt.setUserDate(userojb.getUserDate());
			userdt.setUserStatus(userojb.getUserStatus());
			userdto.add(userdt);
		}	
		}return userdto;
	} 
	
	public UserDto findByDate(Date userDate) {
		UserEntity userren = userrepo.findByDate(userDate);
		UserDto userdto = null;
		if(userren != null) {
			userdto = new UserDto();
			userdto.setFirstName(userren.getFirstName());
			userdto.setLastName(userren.getLastName());
			userdto.setUserAge(userren.getUserAge());
			userdto.setUserPhone(userren.getUserPhone());
			userdto.setUserType(userren.getUserType());
			userdto.setUserDate(userren.getUserDate());
			userdto.setUserStatus(userren.getUserStatus());
			System.out.println("time"+userdto.getUserDate());
		}return userdto;
	}
}
