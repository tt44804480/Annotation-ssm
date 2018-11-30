package com.project.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.entity.VillageEntity;
import com.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@RequestMapping("/test2")
	@ResponseBody
	public Object test2(String userId, @RequestParam(value = "pageNum",required = true,defaultValue = "1") int pageNum,int pageSize){
		Page page =  PageHelper.startPage(pageNum,pageSize);
		List<Map<String,Object>> list =  service.querycusById(userId);
		Map<String,Object> res = new HashMap<>();
		res.put("list",list);
		res.put("total",page.getTotal());
		res.put("pageNum",page.getPageNum());
		return res;
	}

	@RequestMapping("/test3")
	@ResponseBody
	public Object test3(@Valid VillageEntity villageEntity, BindingResult result){

		System.out.println(villageEntity);
		if(result.getErrorCount()>0){
			List<FieldError> fieldErrors = result.getFieldErrors();
			for(FieldError error:fieldErrors){
				System.out.println(error.getField()+"message:" +error.getDefaultMessage());
			}
		}

		return null;
	}
	
}
