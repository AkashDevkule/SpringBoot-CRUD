package com.employee.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmpDTO {

	@NotNull(message = "Id can't be null")
	private int emp_id;
	
	@NotNull(message = "Name can't be null")
	@Pattern(regexp = "([A-Za-z])+(\\s[A-Za-z]+)*", message = "Invalid Name")
	private String emp_name;

	@NotNull(message = "Email can't be null")
	@Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+", message = "Invalid email")
	private String emp_email;

	@NotNull(message = "Mobile No can't be null")
	@Size(max=10, min = 10, message = "Mobile number must be 10 digit")
	@Pattern(regexp = "[0-9]+", message = "Mobile Number is invalid")
	private long emp_mobno;

	@NotNull(message = "City can't be null")
	@Pattern(regexp = "([A-Za-z])+", message = "Invalid City Name")
	private String emp_city;

	public EmpDTO() {
		super();
	}

	public EmpDTO(int emp_id, String emp_name, String emp_email, long emp_mobno, String emp_city) {
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
		return "EmpDTO [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_email=" + emp_email + ", emp_mobno="
				+ emp_mobno + ", emp_city=" + emp_city + "]";
	}

}
