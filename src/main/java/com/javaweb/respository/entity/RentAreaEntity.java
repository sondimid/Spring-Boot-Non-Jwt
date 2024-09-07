package com.javaweb.respository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "value")
	private Integer value;

	@Column(name = "buildingid", insertable = false, updatable = false)
	private Integer buildingId;

	@ManyToOne
	@JoinColumn(name = "buildingid")
	BuildingEntity buildingEntity = new BuildingEntity();

	public RentAreaEntity() {
	}

	public RentAreaEntity(Integer id, Integer value, Integer buildingId) {
		super();
		this.id = id;
		this.value = value;
		this.buildingId = buildingId;
	}

	public BuildingEntity getBuildingEntity() {
		return buildingEntity;
	}

	public void setBuildingEntity(BuildingEntity buildingEntity) {
		this.buildingEntity = buildingEntity;
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

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	
}
