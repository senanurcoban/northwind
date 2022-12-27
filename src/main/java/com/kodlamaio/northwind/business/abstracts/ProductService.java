package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductsResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;



public interface ProductService {

	List<GetAllProductResponse> getAll();    // yanıt
	CreateProductsResponse add(CreateProductRequest createProductRequest);   // data ver
	List<GetAllProductResponse> getByName(String name);   
	GetProductResponse getById(int id);  // all degil
	
}
