package com.javaweb.respository.entity;

public class BuildingEntity {

	private String name;

	private String street;

	private String ward;

	private String managerName;

	private String managerPhoneNumber;

	private Integer id;

	private Integer numberOfBasement;

	private Integer floorArea;

	private Integer rentPrice;

	private Integer serviceFee;

	private Integer brokerageFee;

	private Integer districtId;

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
