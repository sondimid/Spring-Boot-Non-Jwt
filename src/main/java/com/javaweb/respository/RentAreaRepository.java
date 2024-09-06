package com.javaweb.respository;

import java.util.ArrayList;

import com.javaweb.respository.entity.RentAreaEntity;

public interface RentAreaRepository {
	ArrayList<RentAreaEntity> getById(Integer id);
}
