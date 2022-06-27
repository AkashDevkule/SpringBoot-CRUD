package com.employee.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Emp {
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emp_id;
	
	@Column(name="emp_name")
	private String emp_name;
	
	@Column(name="emp_email")
	private String emp_email;
	
	@Column(name="emp_mobno")
	private long emp_mobno;
	
	@Column(name="emp_city")
	private String emp_city;
	
	
	
	public Emp() {
		super();
	}
	public Emp(int emp_id, String emp_name, String emp_email, long emp_mobno, String emp_city) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_mobno = emp_mobno;
		this.emp_city = emp_city;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public long getEmp_mobno() {
		return emp_mobno;
	}
	public void setEmp_mobno(long emp_mobno) {
		this.emp_mobno = emp_mobno;
	}
	public String getEmp_city() {
		return emp_city;
	}
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	@Override
	public String toString() {
		return "Emp [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_email=" + emp_email + ", emp_mobno="
				+ emp_mobno + ", emp_city=" + emp_city + "]";
	}
	
	
	
}
