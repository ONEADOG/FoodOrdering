package com.it.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String phone;
    
}
