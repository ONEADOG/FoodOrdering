package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.TestDto;
import com.it.service.TestService;

@RestController

public class TestController {
@Autowired
private TestService testser;
//
//@PostMapping("/test")
//public void save(@RequestBody TestDto request) {
//	testser.save(request);
//}
}
