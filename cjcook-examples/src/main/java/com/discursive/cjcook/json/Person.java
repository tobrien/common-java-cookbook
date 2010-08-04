package com.discursive.cjcook.json;

public class Person {

	private String name;
	private Integer age;
	private String city;
	
	public Person() {}
	
	public Person(String name, Integer age, String city) {
		setName( name );
		setAge( age );
		setCity( city );
	}

	public String getName() { return name; }
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() { return age; }
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
}
