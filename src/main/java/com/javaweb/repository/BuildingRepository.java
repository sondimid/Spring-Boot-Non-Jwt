package com.javaweb.repository;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.custom.impl.BuildingRepositoryCustom;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer>, BuildingRepositoryCustom {
	List<BuildingEntity> findByBuildingSearchBuilder(BuildingSearchBuilder buildingSearchBuilder);
}
