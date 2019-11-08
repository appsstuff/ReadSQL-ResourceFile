package com.example.lab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERINFO")
public class Person {

	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SALARY")
	private double salary;
	@Column(name = "GENDER")
	private String gender ;
	
	public Person() {
			}

	public Person(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.salary = builder.salary;
		this.gender = builder.gender;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static final  class Builder{
		private Integer id;
		private String name;
		private double salary;
		private String gender ;
		
		public Builder id(Integer id) {this.id = id;return this;}
		public Builder name(String name) {this.name = name;return this;}
		public Builder salary(double salary) {this.salary = salary;return this;}
		public Builder gender(String gender) {this.gender = gender;return this;}
	
		public Person build() {
			return new Person(this);
		} 
	}
	
	
}
