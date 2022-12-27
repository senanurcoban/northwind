package com.kodlamaio.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmloyeesResponse {

	private int id;
	private String firstName;
	private String lastName;
	private double salary;
}
