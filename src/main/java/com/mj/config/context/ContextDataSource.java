package com.mj.config.context;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class ContextDataSource {
	
	@Bean
	public DataSource dataSource() {
		
		HikariConfig hikariConfig = new HikariConfig();

		hikariConfig.setJdbcUrl("jdbc:mariadb://localhost:3306/mybatis");
		hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
		hikariConfig.setUsername("DATABASE_ID");
		hikariConfig.setPassword("DATABASE_PASSWORD");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
	    return dataSource;
	}
}
