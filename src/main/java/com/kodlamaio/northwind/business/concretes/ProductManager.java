package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.ProductService;
import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductsResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;
import com.kodlamaio.northwind.dataAccess.abstracts.ProductRepository;
import com.kodlamaio.northwind.entities.Category;
import com.kodlamaio.northwind.entities.Product;



@Service
public class ProductManager implements ProductService {
	private ProductRepository productRepository;


	@Override
	public List<GetAllProductResponse> getAll() {
		List<Product> products = this.productRepository.findAll();
		List<GetAllProductResponse> allProductResponses = new ArrayList<GetAllProductResponse>();
		for (Product product : products) {
			GetAllProductResponse response = new GetAllProductResponse();
			response.setName(product.getName());
			response.setUnitPrice(product.getUnitPrice());
			response.setUnitsInStock(product.getUnitsInStock());
			response.setCategoryId(product.getCategory().getId());
		    
			allProductResponses.add(response);

		}

		return allProductResponses;
	}

	@Override
	public CreateProductsResponse add(CreateProductRequest createProductRequest) {
		Product product=new Product();
		product.setName(createProductRequest.getName());
		product.setUnitPrice(createProductRequest.getUnitPrice());
		product.setUnitsInStock(createProductRequest.getUnitsInStock());
		
		Category category=new Category();
		category.setId(createProductRequest.getCategoryId());
		product.setCategory(category);
		
		this.productRepository.save(product);
		CreateProductsResponse productResponse = new CreateProductsResponse();

		productResponse.setName(createProductRequest.getName());
		productResponse.setUnitPrice(createProductRequest.getUnitPrice());
		productResponse.setUnitsInStock(createProductRequest.getUnitsInStock());
		productResponse.setCategoryId(createProductRequest.getCategoryId());
		productResponse.setId(product.getId());

		return productResponse;

	}


	@Override
	public List<GetAllProductResponse> getByName(String name) {
		List<Product> products = new ArrayList<Product>();
		List<GetAllProductResponse> productsResponse = new ArrayList<GetAllProductResponse>();

		for (Product product : products) {
			if (product.getName() == name) {
				GetAllProductResponse responseItem = new GetAllProductResponse();
				responseItem.setId(product.getId());
				responseItem.setName(product.getName());
				responseItem.setUnitPrice(product.getUnitPrice());
				responseItem.setUnitsInStock(product.getUnitsInStock());
				responseItem.setCategoryName(product.getCategory().getName());
				productsResponse.add(responseItem);
			}
		}
		return productsResponse;
		
	}

	@Override
	public GetProductResponse getById(int id) {
		GetProductResponse productResponse = new GetProductResponse();
		var result = productRepository.findById(id).get();
		productResponse.setId(result.getId());
		productResponse.setName(result.getName());
		productResponse.setUnitPrice(result.getUnitPrice());
		productResponse.setUnitsInStock(result.getUnitsInStock());
		productResponse.setCategoryName(result.getCategory().getName());
		return productResponse;
	}

}
