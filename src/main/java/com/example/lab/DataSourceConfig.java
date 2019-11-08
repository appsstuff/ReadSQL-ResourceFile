package com.example.lab;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DataSourceConfig {

//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource getDataSource() {
//		return DataSourceBuilder.create().build();
//	}

	
//	@Bean
//	public JdbcTemplate jdbcTemplete() {
//		return new JdbcTemplate(getDataSource());
//	}
}
