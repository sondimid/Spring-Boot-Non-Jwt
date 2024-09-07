package com.javaweb.respository;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.respository.entity.BuildingEntity;

public interface BuildingRespository {
	List<BuildingEntity> listBuildingRepo(BuildingSearchBuilder buildingSearchBuilder);
}
