package com.kodlamaio.northwind.webApi.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.ProductService;
import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.responses.GetAllProductResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;



@RestController
@RequestMapping("/api/products")
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@GetMapping("/getall")
	public List<GetAllProductResponse> getAll(){
		return productService.getAll();
	}
	@GetMapping("/getbyname")
	public List<GetAllProductResponse> getByName(String name){
		return productService.getByName(name);
	}
	@GetMapping("getbyid")
	public GetProductResponse getById(int id) {
		return productService.getById(id);
	}
	@PostMapping("/add")
	public void add(@RequestBody()CreateProductRequest createProductRequest) {
		this.productService.add(createProductRequest);
	
	}
	
	

}
