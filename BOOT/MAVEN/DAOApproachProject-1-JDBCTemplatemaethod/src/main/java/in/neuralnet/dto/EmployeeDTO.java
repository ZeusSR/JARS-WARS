package in.neuralnet.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer int_id;
	
	private String s_address;
	
	private String s_name;
	
	private double d_salary;

	public Integer getInt_id() {
		return int_id;
	}

	public void setInt_id(Integer int_id) {
		this.int_id = int_id;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public double getD_salary() {
		return d_salary;
	}

	public void setD_salary(double d_salary) {
		this.d_salary = d_salary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [int_id=" + int_id + ", s_address=" + s_address + ", s_name=" + s_name + ", d_salary="
				+ d_salary + "]";
	}
	
	
	

}
