package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {

	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.initialSize}")
	private int initialSize;

	@Value("${jdbc.validationQuery}")
	private String validationQuery;
	
	@Bean
	public DruidDataSource druidDataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUsername(this.username);
		druidDataSource.setPassword(this.password);
		druidDataSource.setUrl(this.url);
		druidDataSource.setDriverClassName(this.driver);
		
		druidDataSource.setInitialSize(initialSize);
		druidDataSource.setValidationQuery(this.validationQuery);
		return druidDataSource;
	}
	
	/**
	 * @param druidDataSource
	 * @return
	 * ����
	 */
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource){
	    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
	    dataSourceTransactionManager.setDataSource(druidDataSource);
	    return dataSourceTransactionManager;
	}
}
