package com.javaweb.ConvertDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.api.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class ConvertDTO {
	
	@Autowired
	private ModelMapper modelMapper;

	public BuildingDTO toBuildingDTO(BuildingEntity buildingEntity) {

		BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
		
		DistrictEntity districtEntity = buildingEntity.getDistrictEntity();
		buildingDTO.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + districtEntity.getName());
		
		List<RentAreaEntity> rentAreaEntities = buildingEntity.getRentAreaEntities();
		
		String rentArea = rentAreaEntities.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(", "));
		
		buildingDTO.setRentArea(rentArea);
				
		return buildingDTO;
	}
}
