package com.my.main.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MainDao {
	public List<Map<String, Object>> selectStudentAttend(Map<String, Object> reqMap);
}
