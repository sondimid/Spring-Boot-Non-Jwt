package com.javaweb.respository;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.respository.custom.impl.BuildingRepositoryCustom;
import com.javaweb.respository.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRespository extends JpaRepository<BuildingEntity, Integer>, BuildingRepositoryCustom {
	List<BuildingEntity> listBuildingRepo(BuildingSearchBuilder buildingSearchBuilder);
}
