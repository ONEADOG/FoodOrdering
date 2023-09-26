package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.TableDto;
import com.it.service.TableService;

@RestController
public class TableController {
   @Autowired
	private TableService tableser;
  
   
   @GetMapping("/table")
   public List<TableDto> getall(){
	   return tableser.getAll();
   }
   @GetMapping("/table/{tableId}")
   public TableDto getById(@PathVariable Integer tableId) {
	   return tableser.getById(tableId);   
   }
   
   @PostMapping("/table")
   public void save(@RequestBody TableDto request) {
	   tableser.save(request);
   } 
   @PutMapping("/table/{tableId}")
   public void update(@PathVariable Integer tableId,@RequestBody TableDto request ) {
	   tableser.update(tableId, request);
   }
   @DeleteMapping("/table/{tableId}")
   public void deleteById(@PathVariable Integer tableId) {
	   tableser.deleteById(tableId);
   }
   @GetMapping("/tablen")
   public TableDto getByName(@RequestParam(name="tableName") String tableName) {
	   return tableser.getBytableName(tableName);   
   }
}
