package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration


@ComponentScan(basePackages= {"com.spring.jdbc.dao"})
public class JdbcConfig {
	
	@Bean("datas")
	//instead of DriverManagerDataSource we write DataSource
   public DriverManagerDataSource getDataSource() {
		
		DriverManagerDataSource datas=new DriverManagerDataSource();
		datas.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datas.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		datas.setUsername("root");
		datas.setPassword("Namratak@98");
		return datas;
   }
	
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
		
	}
	
	/*
	 //Declare using @Autowiring
	 * @Bean("studentDao")
	public StudentDao getStudentDao() {
		StudentDaoImpl studentDao=new StudentDaoImpl();
		
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
		
	}*/
	

}
