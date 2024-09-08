package com.javaweb.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "district")
public class DistrictEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "districtEntity", fetch = FetchType.LAZY)
	private List<BuildingEntity> buildingEntities = new ArrayList<>();

	public List<BuildingEntity> getBuildingEntities() {
		return buildingEntities;
	}

	public void setBuildingEntities(List<BuildingEntity> buildingEntities) {
		this.buildingEntities = buildingEntities;
	}

	public DistrictEntity(String code, String name, Integer id) {
		super();
		this.code = code;
		this.name = name;
		this.id = id;
	}
	public DistrictEntity() {
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
