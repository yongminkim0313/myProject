package com.my.main.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.main.dao.MainDao;

@Service
public class MainService {

	@Resource
	private MainDao mainDao;

	public List<Map<String, Object>> selectStudentAttend(Map<String, Object> reqMap){
		return mainDao.selectStudentAttend(reqMap);
	}
}
