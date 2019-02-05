package com.config;

import java.io.IOException;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan(value={"com.config","com.project","com.common","com.activemqProcessor"},excludeFilters={
		@Filter(type=FilterType.ANNOTATION,value={Controller.class})})
@PropertySource(value = {"classpath:db.properties"})
@EnableTransactionManagement
//@EnableAspectJAutoProxy
public class RootConfig {
	
	private String configLocation = "Mybatis-config.xml";
	private String mapperLocations = "classpath*:com/**/*Sql.xml";
	private String mapperScannerBasePackage = "com";
	 
	/**
	 * ���mybatis
	 * @return
	 * @throws IOException 
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DruidDataSource druidDataSource) throws IOException{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(druidDataSource);
		ResourceLoader loader = new DefaultResourceLoader();
		bean.setConfigLocation(loader.getResource(this.configLocation));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources(this.mapperLocations));
		return bean;
	}
	
	/**
	 * ɨ������Mapper�ӿڣ�ʵ���ܹ�ͨ��Autowired�Զ�ע��
	 * @return
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
	    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
	    mapperScannerConfigurer.setAnnotationClass(Repository.class);
	    mapperScannerConfigurer.setBasePackage(this.mapperScannerBasePackage);
	    return mapperScannerConfigurer;
	}
	
	

}
