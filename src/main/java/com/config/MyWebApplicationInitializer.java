package com.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

public class MyWebApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		System.out.println("我启动了");
		 CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	     characterEncodingFilter.setEncoding("UTF-8");
	     characterEncodingFilter.setForceEncoding(true);
		 Dynamic characterEncodingFilterDynamic = servletContext.addFilter("encodingFilter", characterEncodingFilter);
		 characterEncodingFilterDynamic.addMappingForUrlPatterns(null, true, "/*");
		
	}

}
