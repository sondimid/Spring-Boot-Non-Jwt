package com.javaweb.respository.entity;

public class RentAreaEntity {
	private Integer id, value, buildingid;

	public RentAreaEntity(Integer id, Integer value, Integer buildingid) {
		super();
		this.id = id;
		this.value = value;
		this.buildingid = buildingid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(Integer buildingid) {
		this.buildingid = buildingid;
	}
	
}
