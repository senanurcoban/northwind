package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateEmployeeRequest;
import com.kodlamaio.northwind.business.responses.CreateEmployeeResponse;
import com.kodlamaio.northwind.business.responses.GetAllEmloyeesResponse;
import com.kodlamaio.northwind.business.responses.GetEmployeeResponse;


public interface EmployeeService {

	List<GetAllEmloyeesResponse> getAll();
	CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest);
	
	List<GetEmployeeResponse> getByFirstName(String name);
}
