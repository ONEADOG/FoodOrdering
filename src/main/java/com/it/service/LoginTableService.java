package com.it.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.modelmapper.TypeToken;
import com.it.entity.TableEntity;
import com.it.model.TableDto;
import com.it.repository.LogintableRepository;

@Service
public class LoginTableService {

	@Autowired
	private LogintableRepository loginrepo;
	
	@Autowired
	private ModelMapper mm;
	
	public TableDto Login(String tableName) {
		TableEntity tablen = loginrepo.loginByTablename(tableName);
		if(tablen != null) {
			return mm.map(tablen, new TypeToken<TableDto>() {
			}.getType());
		}return null;
	}
}
