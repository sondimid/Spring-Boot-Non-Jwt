package com.javaweb.respository.entity;

public class DistrictEntiry {

	private String code, name;
	private Integer id;
	public DistrictEntiry(String code, String name, Integer id) {
		super();
		this.code = code;
		this.name = name;
		this.id = id;
	}
	public DistrictEntiry() {
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
