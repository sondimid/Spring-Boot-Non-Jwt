package com.javaweb.ConvertDTO;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, ArrayList<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
													.setName(MapUtil.getObject(params, "name", String.class))
													.setDistrictId(MapUtil.getObject(params, "districtId", Integer.class))
													.setFloorArea(MapUtil.getObject(params, "floorArea", Integer.class))	
													.setManagerName(MapUtil.getObject(params, "managerName", String.class))
													.setManagerPhoneNumber(MapUtil.getObject(params, "mangerPhoneNumber", String.class))
												    .setNumberOfBasement(MapUtil.getObject(params, "numberOfBasement", Integer.class))
												    .setRentPriceFrom(MapUtil.getObject(params, "rentPriceFrom", Integer.class))
												    .setRentPriceTo(MapUtil.getObject(params, "rentPriceTo", Integer.class))
												    .setRentAreaFrom(MapUtil.getObject(params, "rentAraeFrom", Integer.class))
												    .setRentAreaTo(MapUtil.getObject(params, "rentAreaTo", Integer.class))
												    .setStaffId(MapUtil.getObject(params, "satffId", Integer.class))
												    .setStreet(MapUtil.getObject(params, "street", String.class))
												    .setWard(MapUtil.getObject(params, "ward", String.class))
												    .setTypeCode(typeCode).build();
		return buildingSearchBuilder;
	}
}
