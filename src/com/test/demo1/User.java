package com.test.demo1;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -1779340878478024944L;
	
	private String name;
	
	private Integer age;
	
	private float height;
	
	private float weight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	

}
