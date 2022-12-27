package com.kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByFirstName(String name);
}
