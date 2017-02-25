package com.tsymbaliuk.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.tsymbaliuk.dao.TaskDAO;
import com.tsymbaliuk.entity.Task;

@Component("taskDAO")
public class TaskDAOImpl implements TaskDAO{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Task> getAll() {
		String query = "select * from tasks";
		List<Task> tasks = new ArrayList<Task>();
		tasks=jdbcTemplate.query(query, new BeanPropertyRowMapper(Task.class));
		return tasks;
	}


	@Override
	public void deleteById(long id) {
		String query = "delete from tasks where id="+id;
		jdbcTemplate.execute(query);
		
	}

}
