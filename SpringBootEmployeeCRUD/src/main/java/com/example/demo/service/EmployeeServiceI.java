package com.example.demo.service;
import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeServiceI {

    Employee CreateEmployee(Employee emp);
    
	Employee findEmployeeById(long empId);
	
	Employee updateEmployee(Employee emp); 
	
	List<Employee> findAllEmployees();
	
	void deleteEmployee(long empId);
	
}
