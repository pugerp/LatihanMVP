package com.example.latihanmvp.data.model.employee;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class EmployeeResp{

	@Expose
	@SerializedName("profile_image")
	private String profileImage;

	@Expose
	@SerializedName("employee_name")
	private String employeeName;

	@Expose
	@SerializedName("employee_salary")
	private String employeeSalary;

	@Expose
	@SerializedName("id")
	private String id;

	@Expose
	@SerializedName("employee_age")
	private String employeeAge;

	public void setProfileImage(String profileImage){
		this.profileImage = profileImage;
	}

	public String getProfileImage(){
		return profileImage;
	}

	public void setEmployeeName(String employeeName){
		this.employeeName = employeeName;
	}

	public String getEmployeeName(){
		return employeeName;
	}

	public void setEmployeeSalary(String employeeSalary){
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeSalary(){
		return employeeSalary;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEmployeeAge(String employeeAge){
		this.employeeAge = employeeAge;
	}

	public String getEmployeeAge(){
		return employeeAge;
	}

	@Override
 	public String toString(){
		return 
			"EmployeeResp{" + 
			"profile_image = '" + profileImage + '\'' + 
			",employee_name = '" + employeeName + '\'' + 
			",employee_salary = '" + employeeSalary + '\'' + 
			",id = '" + id + '\'' + 
			",employee_age = '" + employeeAge + '\'' + 
			"}";
		}
}