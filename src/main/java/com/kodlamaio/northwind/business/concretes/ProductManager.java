package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.ProductService;
import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductsResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;
import com.kodlamaio.northwind.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.northwind.dataAccess.abstracts.CategoryRepository;
import com.kodlamaio.northwind.dataAccess.abstracts.ProductRepository;
import com.kodlamaio.northwind.entities.Category;
import com.kodlamaio.northwind.entities.Product;



@Service
public class ProductManager implements ProductService {
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;

	public ProductManager(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

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
		/*Product product=new Product();
		product.setName(createProductRequest.getName());
		product.setUnitPrice(createProductRequest.getUnitPrice());
		product.setUnitsInStock(createProductRequest.getUnitsInStock());
		Category category=new Category();
		category.setId(createProductRequest.getCategoryId());
		product.setCategory(category);
		*/
		
		Product product=this.modelMapperService.forRequest().map(createProductRequest,Product.class);
		this.productRepository.save(product);
		CreateProductsResponse response=this.modelMapperService.forResponse().map(product,CreateProductsResponse.class);
		
		return response;
	}


	@Override
	public List<GetAllProductResponse> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetProductResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
