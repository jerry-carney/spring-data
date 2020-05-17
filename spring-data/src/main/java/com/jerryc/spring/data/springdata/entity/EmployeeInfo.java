package com.jerryc.spring.data.springdata.entity;


public class EmployeeInfo {	
	private String first_name;
	private String department_name;
	private String location;
	
	public EmployeeInfo() {}

	public EmployeeInfo(String first_name, String department_name, String location) {
		super();
		this.first_name = first_name;
		this.department_name = department_name;
		this.location = location;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "\nEmployeeInfo [first_name=" + first_name + ", department_name=" + department_name + ", location="
				+ location + "]";
	}
}
