package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateCategoryRequest;
import com.kodlamaio.northwind.business.requests.DeleteCategoryRequest;
import com.kodlamaio.northwind.business.requests.UpdateCategoryRequest;
import com.kodlamaio.northwind.business.responses.CreateCategoryResponse;
import com.kodlamaio.northwind.business.responses.DeleteCategoryResponse;
import com.kodlamaio.northwind.business.responses.GetAllCategoryResponse;
import com.kodlamaio.northwind.business.responses.GetCategoryResponse;
import com.kodlamaio.northwind.business.responses.UpdateCategoryResponse;

public interface CategoryService {

	List<GetAllCategoryResponse> getAllCategory();
	CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest);
	List<GetAllCategoryResponse> getByName(String name);
	GetCategoryResponse getById(int id);
	DeleteCategoryResponse deleteCategory(DeleteCategoryRequest deleteCategoryRequest);
	UpdateCategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest);
	
}
