package com.mj.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mj.config.context.ContextDataSource;
import com.mj.config.context.ContextMyBatis;
import com.mj.config.context.ContextTransaction;

@Configuration
@Import({ContextDataSource.class,
		 ContextMyBatis.class,
		 ContextTransaction.class})
@ComponentScan(basePackages = {"com.mj.controller",
							   "com.mj.service",
							   "com.mj.dao"})
@MapperScan(basePackages = {"com.mj.mapper"})
public class RootConfig {
	
}