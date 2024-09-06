package com.javaweb.ConvertDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.api.BuildingDTO;
import com.javaweb.respository.DistrictRepository;
import com.javaweb.respository.RentAreaRepository;
import com.javaweb.respository.entity.BuildingEntity;
import com.javaweb.respository.entity.DistrictEntiry;
import com.javaweb.respository.entity.RentAreaEntity;

@Component
public class ConvertDTO {
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public BuildingDTO toBuildingDTO(BuildingEntity buildingEntity) {

		BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
		
		DistrictEntiry districtEntiry = districtRepository.getById(buildingEntity.getDistrictId());
		buildingDTO.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + districtEntiry.getName());
		
		ArrayList<RentAreaEntity> rentAreaEntities = rentAreaRepository.getById(buildingEntity.getId()); 
		
		String rentArea = rentAreaEntities.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(", "));
		
		buildingDTO.setRentArea(rentArea);
				
		return buildingDTO;
	}
}
