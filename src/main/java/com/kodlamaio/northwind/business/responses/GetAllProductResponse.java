package com.kodlamaio.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {

	private int id;
	private int categoryId;
	private String name;
	private String categoryName;
	private double unitPrice;
	private int unitsInStock;
}
