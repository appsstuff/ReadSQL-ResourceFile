package com.example.lab;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DataSourceConfig {

	@Autowired 
	private DataSource dataSource;
	
	private DataSourceInitializer dataSourceInitializer(Resource resource) {
	final DataSourceInitializer initializer = new DataSourceInitializer();
	initializer.setDataSource(dataSource);
	initializer.setDatabasePopulator(databasePopulator(resource));
	return initializer;
	}
	
	private DatabasePopulator databasePopulator(Resource dataScript) {
	final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	populator.addScript(dataScript);
	return populator;
	}
	
	public void execute(Resource dataScript) {		
		DatabasePopulatorUtils.execute(databasePopulator(dataScript), dataSource);
	}
}
