package com.didispace.domain;

public class Manager {

	private Long id ;
	
	private String name;
	
	private Integer age;
	
	private String power;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", age=" + age + ", power=" + power + "]";
	}
	
}
