package com.example.lab;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class DemoService {

	@Autowired
	private JdbcTemplate jdbc;
	
	// use queryBuilder class
	@Value("#{queryBuilder.getStatement('insertPerson')}")
	private String sql1;
	
	@Value("#{queryBuilder.getStatement('CreateTableDept')}")
	private String sql2;
	
	// use Resource 
	@Value("classpath:query/insertPerson2.sql")
	private Resource resource;
	
	public void addNewPerson() {
		Object[] o = new Object[] {10,"Muhammad",1200,"M	"};
		jdbc.update(sql1,o);
	}
	
	public void addNewPerson2() {
		Object[] o = new Object[] {20,"Heba",5500,"F"};
		String query = extractQueryFromResource(resource);
		jdbc.update(query,o);
	}
	private String extractQueryFromResource(Resource resource) {
		try {
			InputStream is = resource.getInputStream();
			Reader read = new InputStreamReader(is);
			return FileCopyUtils.copyToString(read);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createDeptTable() {
		jdbc.execute(sql2);
	}
}
