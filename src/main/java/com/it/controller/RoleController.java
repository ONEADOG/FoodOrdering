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

import com.it.model.RoleDto;
import com.it.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleser;
	@GetMapping("/Role")
	public List<RoleDto> getAll(){
		return roleser.getAll();
	}
	@GetMapping("/Role/{roleId}")
	public RoleDto getById(@PathVariable Integer roleId) {
		return roleser.getById(roleId);
	}
	@PostMapping("/Role")
	public void save(@RequestBody RoleDto request) {
		roleser.save(request);
	}
	@PutMapping("/Role/{roleId}")
	public void update(@PathVariable Integer roleId,@RequestBody RoleDto request) {
		roleser.update(roleId, request);
	}
	@DeleteMapping("/Role/{roleId}")
	public void deleteById(@PathVariable Integer roleId) {
		roleser.deleteById(roleId);
	}
}
