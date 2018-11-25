package com.project.dao;

import org.springframework.stereotype.Repository;

import com.project.entity.VillageEntity;

@Repository
public interface TestDao {

	public VillageEntity queryVillageById(String id);
}
