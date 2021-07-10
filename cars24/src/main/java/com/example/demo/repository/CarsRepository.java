package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cars;




@Repository
public class CarsRepository {
	@Autowired
	private JdbcTemplate template;
	
	//for adding cars
	public int addCars(Cars car)
	{
		SimpleJdbcInsert inserter = new SimpleJdbcInsert(template);
		inserter.withTableName("cars").usingColumns("model","year","kilometers","brand","status");
		BeanPropertySqlParameterSource sql = new BeanPropertySqlParameterSource(car);
		return inserter.execute(sql);
	}
	
	public List<Cars> getAllCars()
	{
		String sql = "select * from cars";
		List<Cars> carsList =
				template.query(sql, BeanPropertyRowMapper.newInstance(Cars.class));
		return carsList;
	}
	
	public List<Cars> getUnsoldCars()
	{
		String sql = "select * from cars where status='unsold'";
		List<Cars> carsList =
				template.query(sql, BeanPropertyRowMapper.newInstance(Cars.class));
		return carsList;
	}
	
	public List<Cars> getCarsByBrand(String brand)
	{
		String sql = "select * from cars where brand=?";
		//List<Cars> carsList = template.query(sql, BeanPropertyRowMapper.newInstance(Cars.class),brand);
		//List<Cars> carsList = template.query(sql,new Object[]{brand},BeanPropertyRowMapper.newInstance(Cars.class));
		List<Cars> cars =template.query(sql, new Object[]{brand},new BeanPropertyRowMapper<>(Cars.class));
		return cars;
	}
	
	public String[] getBrand()
	{
		String sql = "select distinct(brand) from cars";
		List<String> list = template.queryForList(sql, String.class);
		String[] brands = list.toArray(new String[list.size()]);
	
		return brands;
	}

	
}
