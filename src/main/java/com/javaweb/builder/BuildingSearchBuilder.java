package com.javaweb.builder;

import java.util.ArrayList;

public class BuildingSearchBuilder {
	private String name, street, ward, managerName, managerPhoneNumber;
	private Integer numberOfBasement, floorArea, rentPriceFrom, rentPriceTo, rentAreaFrom, rentAreaTo, staffId,
			serviceFee, brokerageFee, districtId;
	private ArrayList<String> typeCode = new ArrayList<String>();

	private BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.street = builder.street;
		this.ward = builder.ward;
		this.managerName = builder.managerName;
		this.managerPhoneNumber = builder.managerPhoneNumber;
		this.numberOfBasement = builder.numberOfBasement;
		this.floorArea = builder.floorArea;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
		this.districtId = builder.districtId;
		this.typeCode = builder.typeCode;
		this.rentAreaFrom = builder.rentAreaFrom;
		this.rentAreaTo = builder.rentAreaTo;
		this.staffId = builder.staffId;
	}

	public ArrayList<String> getTypeCode() {
		return typeCode;
	}

	public String getName() {
		return name;
	}

	public String getStreet() {
		return street;
	}

	public String getWard() {
		return ward;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public Integer getRentPriceFrom() {
		return rentPriceFrom;
	}

	public Integer getRentPriceTo() {
		return rentPriceTo;
	}

	public Integer getRentAreaFrom() {
		return rentAreaFrom;
	}

	public Integer getRentAreaTo() {
		return rentAreaTo;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public Integer getFloorArea() {
		return floorArea;
	}



	public Integer getServiceFee() {
		return serviceFee;
	}

	public Integer getBrokerageFee() {
		return brokerageFee;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public static class Builder {
		private String name, street, ward, managerName, managerPhoneNumber;
		private Integer numberOfBasement, floorArea, rentPriceFrom, rentPriceTo, rentAreaFrom, rentAreaTo, staffId,
				districtId;
		private ArrayList<String> typeCode = new ArrayList<String>();

		public Builder setDistrictId(Integer districtId) {
			this.districtId = districtId;
			return this;
		}

		public Builder setTypeCode(ArrayList<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}

		public Builder setManagerPhoneNumber(String managerPhoneNumber) {
			this.managerPhoneNumber = managerPhoneNumber;
			return this;
		}

		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Builder setFloorArea(Integer floorArea) {
			this.floorArea = floorArea;
			return this;
		}

		public Builder setRentPriceFrom(Integer rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}

		public Builder setRentAreaFrom(Integer rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}

		public Builder setRentAreaTo(Integer rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}

		public Builder setStaffId(Integer staffId) {
			this.staffId = staffId;
			return this;
		}

		public Builder setRentPriceTo(Integer rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
	}
}
