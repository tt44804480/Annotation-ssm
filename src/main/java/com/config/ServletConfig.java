package com.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.FastJsonpResponseBodyAdvice;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy 
@ComponentScan(value={"com.config","com.project"},includeFilters={
		@Filter(type=FilterType.ANNOTATION,value=Controller.class)
},useDefaultFilters=false)
public class ServletConfig extends WebMvcConfigurerAdapter{
	
	@Autowired(required=false)
	StringHttpMessageConverter converter;
	@Autowired(required=false)
	FastJsonHttpMessageConverter fastJsonHttpMessageConverter;
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(this.converter);
		converters.add(this.fastJsonHttpMessageConverter);
	}
	
	@Bean
	public CommonsMultipartResolver commonsMultipartResolver(){
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		return resolver;
	}
	
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter(){
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		this.converter = converter;
		return converter;
	}
	
	@Bean
	public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.TEXT_HTML);
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		converter.setSupportedMediaTypes(supportedMediaTypes);
		converter.setFeatures(SerializerFeature.WriteMapNullValue);
		this.fastJsonHttpMessageConverter = converter;
		return converter;
	}
	
	//@Bean
	public FastJsonpResponseBodyAdvice fastJsonpResponseBodyAdvice(){
		FastJsonpResponseBodyAdvice advice = new FastJsonpResponseBodyAdvice("callback","jsonp");
		return advice;
	}

	/**
	 * 配置JSR303和国际化资源文件
	 * @return
	 */
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("ValidationMessages");
		return messageSource;
	}
	

	

}
