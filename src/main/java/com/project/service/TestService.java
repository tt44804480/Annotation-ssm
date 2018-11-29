package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.dao.TestDao;
import com.project.entity.VillageEntity;

import java.util.List;
import java.util.Map;

@Service
public class TestService {
	
	@Autowired
	private  TestDao testDao;
	
	public VillageEntity queryVillageById(String id){
		return testDao.queryVillageById(id);
	}

	public List<Map<String,Object>> querycusById(String userId){
		return testDao.querycusById(userId);
	}

}
