package com.javaweb.respository.custom.impl;


import com.javaweb.respository.entity.BuildingEntity;

import java.util.ArrayList;
import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findByBuildingSearchBuilder = new ArrayList<>();
}
