package com.project.dao;

import org.springframework.stereotype.Repository;

import com.project.entity.VillageEntity;

import java.util.List;
import java.util.Map;

@Repository
public interface TestDao {

	public VillageEntity queryVillageById(String id);

	public List<Map<String,Object>> querycusById(String id);
}
