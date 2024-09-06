package com.javaweb.respository.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.Connector.Connector;
import com.javaweb.respository.DistrictRepository;
import com.javaweb.respository.entity.DistrictEntiry;

@Repository
public class DistrictRespositoryImpl implements DistrictRepository {

	@Override
	public DistrictEntiry getById(Integer id) {

		String sql = " SELECT d.* FROM district d WHERE d.id = " + Integer.toString(id);
		DistrictEntiry result = new DistrictEntiry();
		try (Connection connection = Connector.getConnect();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);) {

			while (resultSet.next()) {
				DistrictEntiry districtEntiry = new DistrictEntiry(resultSet.getString("code"),
						resultSet.getString("name"), resultSet.getInt("id"));
				result = districtEntiry;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
