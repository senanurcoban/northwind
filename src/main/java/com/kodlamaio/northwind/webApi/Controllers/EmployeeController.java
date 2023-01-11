package com.kodlamaio.northwind.webApi.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.EmployeeService;
import com.kodlamaio.northwind.business.requests.CreateEmployeeRequest;
import com.kodlamaio.northwind.business.responses.CreateEmployeeResponse;
import com.kodlamaio.northwind.business.responses.GetAllEmloyeesResponse;
import com.kodlamaio.northwind.business.responses.GetEmployeeResponse;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/getall")
	public List<GetAllEmloyeesResponse> getAll(){
		return employeeService.getAll();
	}
	
	@PostMapping("/add")
	public CreateEmployeeResponse add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		 return this.employeeService.add(createEmployeeRequest);
	}
	@GetMapping("/getByFirstName")
	public List<GetEmployeeResponse> getByFirstName(String name) {
		return employeeService.getByFirstName(name);
		
		
	}
}
