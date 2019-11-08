package com.example.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoAsCommandLineRunner implements CommandLineRunner {

	@Autowired
	private DemoService service;
	
	@Override
	public void run(String... args) throws Exception {
	service.addNewPerson();	
	service.createDeptTable();
	service.addNewPerson2();
	service.createLocationTable();
	}

}
