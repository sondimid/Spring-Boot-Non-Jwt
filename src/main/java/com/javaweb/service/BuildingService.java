package com.javaweb.service;

import java.util.ArrayList;
import java.util.Map;

import com.javaweb.api.BuildingDTO;

public interface BuildingService {
	
	ArrayList<BuildingDTO> listService(Map<String, Object> map, ArrayList<String> typeCode);
	
}
