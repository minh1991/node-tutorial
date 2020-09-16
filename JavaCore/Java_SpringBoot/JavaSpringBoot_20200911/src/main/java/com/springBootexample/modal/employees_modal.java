package com.springBootexample.modal;

public class employees_modal {
	private int employee_id;
	private String employee_name;
	private int employee_age;

	public employees_modal(int employee_id, String employee_name, int employee_age) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_age = employee_age;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public int getEmployee_age() {
		return employee_age;
	}

	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}
}
