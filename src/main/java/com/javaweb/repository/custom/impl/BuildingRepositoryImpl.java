package com.javaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import com.javaweb.repository.BuildingRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;

import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

	public void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		Integer staffId = buildingSearchBuilder.getStaffId();
		Integer rentAreaFrom = buildingSearchBuilder.getRentAreaFrom();
		Integer rentAreaTo = buildingSearchBuilder.getRentAreaTo();
		Integer districtId = buildingSearchBuilder.getDistrictId();

		List<String> typeCode = buildingSearchBuilder.getTypeCode();

		if (staffId != null) {
			sql.append(" JOIN assignmentbuilding a ON b.id = a.staffid ");
		}

		if (typeCode != null && !typeCode.isEmpty()) {
			sql.append(" JOIN buildingrenttype br ON b.id = br.buildingid ");
			sql.append(" JOIN renttype r ON br.renttypeid = r.id");
		}

		if (rentAreaFrom != null || rentAreaTo != null) {
			sql.append(" JOIN rentarea ra ON b.id = ra.buildingid ");
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
	@PersistenceContext
	private EntityManager entityManager;

	public void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {

		Integer staffId = buildingSearchBuilder.getStaffId();
		Integer rentAreaFrom = buildingSearchBuilder.getRentAreaFrom();
		Integer rentAreaTo = buildingSearchBuilder.getRentAreaTo();
		Integer rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
		Integer rentPriceTo = buildingSearchBuilder.getRentPriceTo();
		Integer districtId = buildingSearchBuilder.getDistrictId();
		List<String> typeCode = buildingSearchBuilder.getTypeCode();

		if (staffId != null) {
			sql.append(" AND a.staffid = " + staffId.toString());
		}

		if (rentAreaFrom != null) {
			sql.append(" AND ra.value >= " + rentAreaFrom.toString());
		}

		if (rentAreaTo != null) {
			sql.append(" AND ra.value <= " + rentAreaTo.toString());
		}

		if (rentPriceFrom != null) {
			sql.append(" AND b.rentprice >= " + rentPriceFrom.toString());
		}

		if (rentPriceTo != null) {
			sql.append(" AND b.rentprice <= " + rentPriceTo.toString());
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
	public List<BuildingEntity> findByBuildingSearchBuilder(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");
		joinTable(buildingSearchBuilder, sql);
		queryNormal(buildingSearchBuilder, sql);
		querySpecial(buildingSearchBuilder, sql);

		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();

	}

}
