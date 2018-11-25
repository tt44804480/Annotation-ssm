package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.project.entity.VillageEntity;
import com.project.service.TestService;

@Controller
@RequestMapping(value="/testController",produces="application/json;charset=UTF-8")
public class TestController {
	
	@Autowired
	private TestService service;

	@RequestMapping("/test1")
	@ResponseBody
	public Object test1(String name){
		System.out.println(name);
		VillageEntity villageEntity = service.queryVillageById("village1001");
		System.out.println(villageEntity);
		return villageEntity;
	}
	
}
