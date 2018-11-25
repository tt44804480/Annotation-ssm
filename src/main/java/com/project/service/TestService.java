package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.dao.TestDao;
import com.project.entity.VillageEntity;

@Service
public class TestService {
	
	@Autowired
	private  TestDao testDao;
	
	public VillageEntity queryVillageById(String id){
		return testDao.queryVillageById(id);
	}

}
