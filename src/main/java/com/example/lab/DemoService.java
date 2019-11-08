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
	
	@Value("#{queryBuilder.getStatement('insertPerson')}")
	private String sql1;
	

	@Value("#{queryBuilder.getStatement('CreateTableDept')}")
	private String sql2;
	
	@Value("classpath:query/insertPerson2.sql")
	private Resource sql3;
	
	public void addNewPerson() {
		Object[] o = new Object[] {10,"Muhammad",1200,"M	"};
		jdbc.update(sql1,o);
	}
	
	public void addNewPerson2() {
		Object[] o = new Object[] {20,"Heba",5500,"F"};
		String s = asString(sql3);
		jdbc.update(s,o);
	}
	private String asString(Resource resource) {
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
