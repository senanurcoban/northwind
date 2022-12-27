package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.EmployeeService;
import com.kodlamaio.northwind.business.requests.CreateEmployeeRequest;
import com.kodlamaio.northwind.business.responses.CreateEmployeeResponse;
import com.kodlamaio.northwind.business.responses.GetAllEmloyeesResponse;
import com.kodlamaio.northwind.business.responses.GetEmployeeResponse;
import com.kodlamaio.northwind.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.northwind.dataAccess.abstracts.EmployeeRepository;

import com.kodlamaio.northwind.entities.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllEmloyeesResponse> getAll() {
		List<Employee> employees=employeeRepository.findAll();
		List<GetAllEmloyeesResponse> employeeResponse=new ArrayList<GetAllEmloyeesResponse>();
		for(Employee employee:employees) {
			GetAllEmloyeesResponse responseItem=new GetAllEmloyeesResponse();
			responseItem.setId(employee.getId());
			responseItem.setFirstName(employee.getFirstName());
			responseItem.setLastName(employee.getLastName());
			
			employeeResponse.add(responseItem);
		}
		return employeeResponse;
	}

	
	@Override
	public CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest) {
		
		
		Employee employee=this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
		this.employeeRepository.save(employee);
		CreateEmployeeResponse employeeResponse=this.modelMapperService.forResponse().map(employee,CreateEmployeeResponse.class);
		return employeeResponse;
		
		/*Employee employee=new Employee();
		employee.setFirstName(createEmployeeRequest.getFirstName());
		employee.setLastName(createEmployeeRequest.getLastName());
		this.employeeRepository.save(employee);*/
		
	}
	@Override
	public List<GetEmployeeResponse> getByFirstName(String name) {
		List<GetEmployeeResponse> getEmployeeResponse=new ArrayList<GetEmployeeResponse>();
		List<Employee> employees=this.employeeRepository.findByFirstName(name);
		for(Employee employee: employees) {
			GetEmployeeResponse responseItem=new GetEmployeeResponse();
			responseItem.setId(employee.getId());
			responseItem.setFirstName(employee.getFirstName());
			responseItem.setLastName(employee.getLastName());
			responseItem.setSalary(employee.getSalary());
			
			getEmployeeResponse.add(responseItem);
		}
		
		return getEmployeeResponse;
		
		
		
		
		
	}

}
