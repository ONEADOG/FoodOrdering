package com.it.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.it.entity.LoginEntity;
import com.it.entity.UserEntity;
import com.it.model.EditDto;
import com.it.model.LoginDto;
import com.it.model.RegisterDto;
import com.it.repository.LoginRepository;
import com.it.repository.UserRepository;

@Service
public class LoginService {

	@Autowired 
	private  LoginRepository logrepo;
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private ModelMapper mm;
	
	public LoginDto login( String username,String password ){
		LoginEntity logine = logrepo.login(username, password);
		
		if(logine != null) {
			return mm.map(logine, new TypeToken<LoginDto>() {
			}.getType());
		}
	return null;}  
	
	public List<RegisterDto> getAll(){
		List<LoginEntity> loge = logrepo.findAll();
		List<UserEntity > usere = userrepo.findAll();
		List<RegisterDto> response = null;
		
		if(loge != null  ) {
			if(usere != null ) {
				response = new  ArrayList<>();
				
				for(LoginEntity logojb : loge) {
					RegisterDto respone = new RegisterDto();
					for(UserEntity userojb : usere) {
					if(logojb.getUserId() == userojb.getUserId()) {
						respone.setUserId(userojb.getUserId());
						respone.setFirstName(userojb.getFirstName());
						respone.setLastName(userojb.getLastName());
						respone.setUserAge(userojb.getUserAge());
						respone.setUserPhone(userojb.getUserPhone());
						respone.setUserImage(userojb.getUserImage());
						respone.setUserType(userojb.getUserType());
						respone.setUserDate(userojb.getUserDate());
						respone.setUserStatus(userojb.getUserStatus());
						respone.setUsername(logojb.getUsername());
						respone.setPassword(logojb.getPassword());
						respone.setRoleId(logojb.getRoleid());
						respone.setLoginStatus(logojb.getLoginStatus());
						response.add(respone);}
					}
				}
			}
		}return response;
	}
//	if(logen.isPresent()) && logen.isPresent() 	LoginEntity loge = logen.get();	Optional<LoginEntity> logen = logrepo.findById(userId);{
//	}
	public RegisterDto getById(Integer userId) {
		Optional<UserEntity> usere = userrepo.findById(userId);
		LoginEntity logen = logrepo.findByUserId(userId);
		RegisterDto regisdto = null;
		if(usere.isPresent() ) {
			UserEntity useren = usere.get();
			
				regisdto = new RegisterDto();
				regisdto.setUserId(useren.getUserId());
				regisdto.setFirstName(useren.getFirstName());
				regisdto.setLastName(useren.getLastName());
				regisdto.setUserAge(useren.getUserAge());
				regisdto.setUserPhone(useren.getUserPhone());
				regisdto.setUserType(useren.getUserType());
				regisdto.setUserImage(useren.getUserImage());
				regisdto.setUserDate(useren.getUserDate());
				regisdto.setUserStatus(useren.getUserStatus());
	            regisdto.setUsername(logen.getUsername());
				regisdto.setPassword(logen.getPassword());
				
		}return regisdto;
	
	}
	public RegisterDto getlogin(Integer userId) {
		Optional<LoginEntity> loge = logrepo.findById(userId);
		RegisterDto redto = null;
		if(loge.isPresent()) {
			LoginEntity logren =  loge.get();
			redto = new RegisterDto();
			redto.setUsername(logren.getUsername());
			redto.setPassword(logren.getPassword());
		}return redto;
	}
	public void addUser(RegisterDto request) throws IOException{
		MultipartFile file = request.getFile();
		
		if(request != null) {
			UserEntity usere = new UserEntity();
			LoginEntity loge = new LoginEntity();
			
			usere.setFirstName(request.getFirstName());
			usere.setLastName(request.getLastName());
			usere.setUserAge(request.getUserAge());
			usere.setUserPhone(request.getUserPhone());
			if(file != null && !file.isEmpty()) {
				String filename = file.getOriginalFilename();
				String filepath = "D:\\ProjectFontend\\fontendproject\\src\\assets\\image\\User/"+filename;
				String finalpath = "assets"+"/image/User/"+filename;
				Path path = Path.of(filepath);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				 
				usere.setUserImage(finalpath);
			}
			loge.setUsername(request.getUsername());
			loge.setPassword(request.getPassword());
			usere.setUserType(request.getUserType());
			usere.setUserStatus(1);
			usere.setUserDate(new Date());
			loge.setLoginStatus(1);
			loge.setRoleid(2);
			usere = userrepo.save(usere);
			loge.setUserId(usere.getUserId());
			logrepo.save(loge);
			
			
		}
	}
	
	public void editUser(Integer userId,EditDto request)throws IOException{
		Optional<UserEntity> useren = userrepo.findById(userId);
		MultipartFile file = request.getFile();
		
		if(useren.isPresent()) {
			UserEntity usere = useren.get();
			if(request != null) {
				 	usere.setFirstName(request.getFirstName());
					usere.setLastName(request.getLastName());
					usere.setUserAge(request.getUserAge());
					usere.setUserPhone(request.getUserPhone());
					if(file != null && !file.isEmpty()) {
						String filename = file.getOriginalFilename();
						String filepath = "D:\\ProjectFontend\\fontendproject\\src\\assets\\image\\User/"+filename;
						String finalpath = "assets"+"/image/User/"+filename;
						Path path = Path.of(filepath);
						Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
						
						usere.setUserImage(finalpath);
						
					}
					usere.setUserType(request.getUserType());
					usere.setUserStatus(request.getUserStatus());
				userrepo.save(usere);
			}		
	}}
	
	public void deleteById(Integer userId) {
		userrepo.deleteById(userId);

	}
	public void deleteByIduser(Integer userId) {
		logrepo.deleteById(userId);
	}
	
}

