package com.tsymbaliuk.dao;

import java.util.List;

import com.tsymbaliuk.entity.Task;

public interface TaskDAO {
	public List<Task> getAll();
	public void deleteById(long id);
}
