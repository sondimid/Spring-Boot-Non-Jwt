package com.javaweb.respository.implement;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.Connector.Connector;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.respository.BuildingRespository;
import com.javaweb.respository.entity.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRespositoryImpl implements BuildingRespository {

	public void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		Integer staffId = buildingSearchBuilder.getStaffId();
		Integer rentAreaFrom = buildingSearchBuilder.getRentAreaFrom();
		Integer rentAreaTo = buildingSearchBuilder.getRentAreaTo();
		Integer districtId = buildingSearchBuilder.getDistrictId();
		ArrayList<String> typeCode = buildingSearchBuilder.getTypeCode();

		if (staffId != null) {
			sql.append(" JOIN assignmentbuilding a ON b.id = a.staffid");
		}

		if (typeCode != null && typeCode.size() != 0) {
			sql.append(" JOIN buildingrenttype br ON b.id = br.buildingid");
			sql.append(" JOIN renttype r ON br.renttypeid = r.id");
		}

		if (rentAreaFrom != null || rentAreaTo != null) {
			sql.append(" JOIN rentarea ra ON b.id = ra.buildingid");
		}

		if(districtId != null){
			sql.append(" JOIN district d ON d.id = b.districtid ");
		}
	}

	public void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		sql.append(" WHERE 1=1 ");

		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				
				field.setAccessible(true);
				String fieldName = field.getName();
				
				if (!fieldName.equals("staffId") && !fieldName.equals("districtId") && !fieldName.equals("typeCode")
						&& !fieldName.startsWith("rent") && !fieldName.startsWith("area")) {
					Object value = field.get(buildingSearchBuilder);
					if(value != null) {
						String valueString = value.toString();
						if (NumberUtil.isNum(valueString)) {
							sql.append(" AND b." + fieldName.toLowerCase() + " = " + value);
						} else if (StringUtil.isString(valueString)) {
							sql.append(" AND b." + fieldName.toLowerCase() + " LIKE '%" + value + "%' ");
						}
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		
		Integer staffId = buildingSearchBuilder.getStaffId();
		Integer rentAreaFrom = buildingSearchBuilder.getRentAreaFrom();
		Integer rentAreaTo = buildingSearchBuilder.getRentAreaTo();
		Integer rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
		Integer rentPriceTo = buildingSearchBuilder.getRentPriceTo();
		Integer districtId = buildingSearchBuilder.getDistrictId();
		ArrayList<String> typeCode = buildingSearchBuilder.getTypeCode();

		if (staffId != null) {
			sql.append(" AND a.staffid = " + staffId.toString());
		}

		if (rentAreaFrom != null) {
			sql.append(" AND ra.value >=" + rentAreaFrom.toString());
		}

		if (rentAreaTo != null) {
			sql.append(" AND ra.value <=" + rentAreaTo.toString());
		}

		if (rentPriceFrom != null) {
			sql.append(" AND d.rentprice >=" + rentPriceFrom.toString());
		}

		if (rentPriceTo != null) {
			sql.append(" AND d.rentprice <=" + rentPriceTo.toString());
		}

		if(districtId != null){
			sql.append(" AND d.id = " + districtId.toString());
		}
		if (typeCode != null && typeCode.size() > 0) {
			sql.append(" AND( ");
			String tmp = typeCode.stream().map(it -> "r.code LIKE '%" + it + "%'").collect(Collectors.joining(" OR "));
			sql.append(tmp + " ) ");
		}
		sql.append(" GROUP BY b.id ");
	}

	@Override
	public ArrayList<BuildingEntity> listBuildingRepo(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");
		joinTable(buildingSearchBuilder, sql);
		queryNormal(buildingSearchBuilder, sql);
		querySpecial(buildingSearchBuilder, sql);

		ArrayList<BuildingEntity> list = new ArrayList<>();
		try (Connection connection = Connector.getConnect();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql.toString());) {
			while (resultSet.next()) {
				BuildingEntity buildingEntity = new BuildingEntity(resultSet.getString("name"),
						resultSet.getString("street"), resultSet.getString("ward"), resultSet.getString("managername"),
						resultSet.getString("managerphonenumber"), resultSet.getInt("id"),
						resultSet.getInt("numberofbasement"), resultSet.getInt("floorarea"),
						resultSet.getInt("rentprice"), resultSet.getInt("servicefee"), resultSet.getInt("brokeragefee"),
						resultSet.getInt("districtid"));

				list.add(buildingEntity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
