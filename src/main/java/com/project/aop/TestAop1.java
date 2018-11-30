package com.project.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component 
public class TestAop1 {

	@Pointcut("execution(public Object com.project.controller.TestController.test1(String))")
	public void pointCut(){}
	
	@Before("pointCut()")
	public void before(JoinPoint jp){
		 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		 String name = request.getParameter("name");
		 System.out.println("aop中的name=  "+name);
	}
}
