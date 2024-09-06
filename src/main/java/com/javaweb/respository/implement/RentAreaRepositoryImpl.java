package com.javaweb.respository.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.javaweb.Connector.Connector;
import com.javaweb.respository.RentAreaRepository;
import com.javaweb.respository.entity.RentAreaEntity;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {

	@Override
	public ArrayList<RentAreaEntity> getById(Integer id) {
		String sql = "SELECT * FROM rentarea WHERE buildingid = " + Integer.toString(id);
		ArrayList<RentAreaEntity> list = new ArrayList<RentAreaEntity>();
		try (Connection connection = Connector.getConnect();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);) {

			while (resultSet.next()) {

				RentAreaEntity rentAreaEntity = new RentAreaEntity(resultSet.getInt("id"), resultSet.getInt("value"),
						resultSet.getInt("buildingid"));
				list.add(rentAreaEntity);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
