package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.TestnumberEntity;
import com.it.model.TestDto;
import com.it.repository.TestRepository;
@Service
public class TestService {
@Autowired
private  TestRepository testrepo;


}