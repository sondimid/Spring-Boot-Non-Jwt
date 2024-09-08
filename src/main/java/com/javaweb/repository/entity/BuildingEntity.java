package com.javaweb.repository.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name  = "building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "street")
	private String street;

	@Column(name = "ward")
	private String ward;

	@Column(name = "managername")
	private String managerName;

	@Column(name = "managerphonenumber")
	private String managerPhoneNumber;

	@Column(name = "numberofbasement")
	private Integer numberOfBasement;

	@Column(name = "floorarea")
	private Integer floorArea;

	@Column(name = "rentprice")
	private Integer rentPrice;

	@Column(name = "servicefee")
	private Integer serviceFee;

	@Column(name = "brokeragefee")
	private Integer brokerageFee;

	@Column(name = "districtid", insertable = false, updatable = false)
	private Integer districtId;

	@ManyToOne
	@JoinColumn(name = "districtid")
	DistrictEntity districtEntity = new DistrictEntity();

	@OneToMany(mappedBy = "buildingEntity", fetch = FetchType.LAZY)
	private List<RentAreaEntity> rentAreaEntities = new ArrayList<>();

	public BuildingEntity() {
	}

	public BuildingEntity(String name, String street, String ward, String managerName, String managerPhoneNumber,
						  Integer id, Integer numberOfBasement, Integer floorArea, Integer rentPrice,
						  Integer serviceFee, Integer brokerageFee, Integer districtId) {
		this.id = id;

		this.name = name;

		this.street = street;

		this.ward = ward;

		this.managerName = managerName;

		this.managerPhoneNumber = managerPhoneNumber;

		this.numberOfBasement = numberOfBasement;

		this.floorArea = floorArea;

		this.rentPrice = rentPrice;

		this.serviceFee = serviceFee;

		this.brokerageFee = brokerageFee;

		this.districtId = districtId;
	}

	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}

	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}

	public List<RentAreaEntity> getRentAreaEntities() {
		return rentAreaEntities;
	}

	public void setRentAreaEntities(List<RentAreaEntity> rentAreaEntities) {
		this.rentAreaEntities = rentAreaEntities;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Integer getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}

	public Integer getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Integer getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(Integer serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Integer getBrokerageFee() {
		return brokerageFee;
	}

	public void setBrokerageFee(Integer brokerageFee) {
		this.brokerageFee = brokerageFee;
	}

}
