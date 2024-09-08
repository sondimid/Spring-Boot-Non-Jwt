package com.javaweb.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javaweb.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.ConvertDTO.BuildingSearchBuilderConverter;
import com.javaweb.ConvertDTO.ConvertDTO;
import com.javaweb.api.BuildingDTO;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private ConvertDTO convertDTO;

	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

	@Override
	public List<BuildingDTO> listService(Map<String, Object> map, ArrayList<String> typeCode) {

		List<BuildingDTO> result = new ArrayList<>();
		BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(map,typeCode);

		List<BuildingEntity> list = buildingRepository.findByBuildingSearchBuilder(buildingSearchBuilder);

		for (BuildingEntity buildingEntity : list) {
			BuildingDTO buildingDTO = convertDTO.toBuildingDTO(buildingEntity);
			result.add(buildingDTO);
		}

		return result;
	}

}
