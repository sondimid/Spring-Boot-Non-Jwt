package com.javaweb.repository.custom.impl;


import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.entity.BuildingEntity;

import java.util.ArrayList;
import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findByBuildingSearchBuilder(BuildingSearchBuilder buildingSearchBuilder);
}
