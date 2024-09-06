package com.javaweb.respository;

import java.util.ArrayList;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.respository.entity.BuildingEntity;

public interface BuildingRespository {
	ArrayList<BuildingEntity> listBuildingRepo(BuildingSearchBuilder buildingSearchBuilder);
}
