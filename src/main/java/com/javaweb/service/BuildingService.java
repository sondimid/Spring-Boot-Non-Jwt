package com.javaweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javaweb.api.BuildingDTO;
import org.springframework.stereotype.Component;

public interface BuildingService {
	
	List<BuildingDTO> listService(Map<String, Object> map, ArrayList<String> typeCode);
	
}
