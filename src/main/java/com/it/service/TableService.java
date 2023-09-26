package com.it.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.TableEntity;
import com.it.model.TableDto;
import com.it.repository.TableRepository;
import com.it.repository.TablelogRepository;

@Service
public class TableService {

	@Autowired 
	private TableRepository tablerepo;
	@Autowired
	private TablelogRepository tablelog;
	public List<TableDto> getAll(){
		List<TableEntity> tablen = tablerepo.findAll();
		List<TableDto> tablere = null;
		
		if(tablen != null) {
			tablere = new ArrayList<>();
			for(TableEntity tableojb : tablen) {
				TableDto tables = new TableDto();
				tables.setTableId(tableojb.getTableId());
				tables.setTableName(tableojb.getTableName());
//				tables.setGuestQty(tableojb.getGuestQty());
				tables.setOrdersId(tableojb.getOrdersId());
				tables.setTableStatus(tableojb.getTableStatus());
				tablere.add(tables);
				
			}
		}return tablere;
	}
	
	public TableDto getById(Integer tableId) {
		Optional<TableEntity> tablen = tablerepo.findById(tableId);
		TableDto tableres  = null;
		
		if(tablen.isPresent()) {
			TableEntity tables = tablen.get();
			 tableres = new TableDto();
			 tableres.setTableId(tables.getTableId());
			tableres.setTableName(tables.getTableName());
//			tableres.setGuestQty(tables.getGuestQty());
			tableres.setOrdersId(tables.getOrdersId());
			tableres.setTableStatus(tables.getTableStatus());
			
		}return tableres;
	} 
	public void save(TableDto request) {
		if(request != null) {
			TableEntity tablen = new TableEntity();
			tablen.setTableName(request.getTableName());
//			tablen.setGuestQty(request.getGuestQty());
			tablen.setOrdersId(request.getOrdersId());
			tablen.setTableStatus(request.getTableStatus());
			tablerepo.save(tablen);
		}
	}
	
	public void update(Integer tableId,TableDto request) {
		Optional<TableEntity > tablen = tablerepo.findById(tableId);
		if(tablen.isPresent()) {
		TableEntity	tables = tablen.get();
			if(request != null) {
				
				tables.setTableName(request.getTableName());
//				tables.setGuestQty(request.getGuestQty());
				tables.setOrdersId(request.getOrdersId());
				tables.setTableStatus(request.getTableStatus());
				tablerepo.save(tables);
			}
		}
		
		
	}
	public void deleteById(Integer tableId){
		tablerepo.deleteById(tableId);
	}
	
	public TableDto getBytableName(String tableName) {
		TableEntity tablen = tablerepo.findByTableName(tableName);
		TableDto tableres  = null;
		
		if(tablen!=null) {
			TableEntity tables = tablen;
			 tableres = new TableDto();
			 tableres.setTableId(tables.getTableId());
			tableres.setTableName(tables.getTableName());
			
			tableres.setOrdersId(tables.getOrdersId());
			tableres.setTableStatus(tables.getTableStatus());
			
		}return tableres;
	} 
}
