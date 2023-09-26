package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.entity.EmployeeEntity;
import com.it.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> listEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional(rollbackFor = { Exception.class })
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Transactional(rollbackFor = { Exception.class })
    public EmployeeEntity update(EmployeeEntity request, Integer id) {
        EmployeeEntity employeeEntity = this.getEmployeeById(id);
        if (employeeEntity != null) {
            employeeEntity.setFirstName(request.getFirstName());
            employeeEntity.setLastName(request.getLastName());
            employeeEntity.setGender(request.getGender());
            employeeEntity.setPhone(request.getPhone());
            employeeEntity.setAddress(request.getAddress());
            return employeeRepository.save(employeeEntity);
        } else {
            return null;
        }
    }

    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }


    

}
