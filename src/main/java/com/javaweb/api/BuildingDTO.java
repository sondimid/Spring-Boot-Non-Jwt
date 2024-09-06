package com.javaweb.api;

public class BuildingDTO {
    private String name, address, managerName, managerPhoneNumber, rentArea;
    private Integer numberOfBasement, floorArea, rentPrice, emptyArea, serviceFee, brokerageFee;
  
	
	public BuildingDTO(String name, String address, String managerName, String managerPhoneNumber,
			Integer numberOfBasement, Integer floorArea, Integer rentPrice, String rentArea,
			Integer emptyArea, Integer serviceFee, Integer brokerageFee) {
		super();
		this.name = name;
		this.address = address;
		this.managerName = managerName;
		this.managerPhoneNumber = managerPhoneNumber;
		this.numberOfBasement = numberOfBasement;
		this.floorArea = floorArea;
		this.rentPrice = rentPrice;
		this.rentArea = rentArea;
		this.emptyArea = emptyArea;
		this.serviceFee = serviceFee;
		this.brokerageFee = brokerageFee;
	}


	public BuildingDTO() {
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public Integer getEmptyArea() {
		return emptyArea;
	}


	public void setEmptyArea(Integer emptyArea) {
		this.emptyArea = emptyArea;
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


	public String getRentArea() {
		return rentArea;
	}


	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}


	
	

}
