package com.it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.RoleEntity;
import com.it.model.RoleDto;
import com.it.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository rolerepo;
	
	public List<RoleDto> getAll(){
		List<RoleEntity> rolen = rolerepo.findAll();
		List<RoleDto > roler = null;
		
		if(rolen != null) {
			roler = new ArrayList<>();
			for(RoleEntity roleojb : rolen) {
				RoleDto roles = new RoleDto();
				roles.setRoleId(roleojb.getRoleId());
				roles.setRoleDec(roleojb.getRoleDec());
				roles.setRoleStatus(roleojb.getRoleStatus());
				roler.add(roles);
				
			}
		}return roler;
	}
	public RoleDto getById(Integer roleId) {
		Optional<RoleEntity> rolen = rolerepo.findById(roleId);
		RoleDto roler = null;
		if(rolen.isPresent()) {
			RoleEntity rolent = rolen.get();
			roler = new RoleDto();
			roler.setRoleId(rolent.getRoleId());
			roler.setRoleDec(rolent.getRoleDec());
			roler.setRoleStatus(rolent.getRoleStatus());
		}return roler;
		
	} 
	public void save(RoleDto request) {
		if(request != null) {
			RoleEntity rolen = new RoleEntity();
			rolen.setRoleDec(request.getRoleDec());
			rolen.setRoleStatus(request.getRoleId());
			rolerepo.save(rolen);
		}
	}
	public void update(Integer roleId,RoleDto request) {
		Optional<RoleEntity> rolen = rolerepo.findById(roleId);
		if(rolen.isPresent()) {
			RoleEntity rolet = rolen.get();
			if(request != null) {
				rolet.setRoleDec(request.getRoleDec());
				rolet.setRoleStatus(request.getRoleStatus());
				rolerepo.save(rolet);
			}
		}
	}
	public void deleteById(Integer roleId) {
		rolerepo.deleteById(roleId);
	}
}
