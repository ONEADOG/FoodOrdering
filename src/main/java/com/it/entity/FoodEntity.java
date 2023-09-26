package com.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_food")
public class FoodEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="food_id")
private Integer foodId;

@Column(name="food_name")
private String foodName;

@Column(name="food_qty")
private String foodQty;

@Column(name="food_type")
private String foodType;

@Column(name="food_image")
private String foodImage;

@Column(name="promotion")
private Integer promotion;

@Column(name="food_status")
private Integer foodStatus;
}
