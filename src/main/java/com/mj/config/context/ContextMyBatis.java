package com.mj.config.context;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

public class ContextMyBatis {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);

		/**** MyBatis xml 매핑을 사용할때 적는 부분, 어노테이션만 쓸거면 지워도 무방 ****/
		sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:META-INF/mybatis/mapper/*.xml"));
		/********************************************************************************/
		
		return sqlSessionFactory.getObject();
	}
}
