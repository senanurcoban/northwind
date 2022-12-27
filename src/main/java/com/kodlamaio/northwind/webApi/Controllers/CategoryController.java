package com.kodlamaio.northwind.webApi.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.CategoryService;
import com.kodlamaio.northwind.business.requests.CreateCategoryRequest;
import com.kodlamaio.northwind.business.requests.DeleteCategoryRequest;
import com.kodlamaio.northwind.business.requests.UpdateCategoryRequest;
import com.kodlamaio.northwind.business.responses.CreateCategoryResponse;
import com.kodlamaio.northwind.business.responses.DeleteCategoryResponse;
import com.kodlamaio.northwind.business.responses.GetAllCategoryResponse;
import com.kodlamaio.northwind.business.responses.GetCategoryResponse;
import com.kodlamaio.northwind.business.responses.UpdateCategoryResponse;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryService categoryService;
	
	@GetMapping("/getall")
	public List<GetAllCategoryResponse> getAllCategory(){
		return categoryService.getAllCategory();
	}
	
	@PostMapping("/add")
	public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
		return categoryService.add(createCategoryRequest);
	}
	
	@GetMapping("/getbyname")
	public List<GetAllCategoryResponse> getbyname(String name){
		return categoryService.getByName(name);
	}
	@GetMapping("/getbyid/{id}")
	public GetCategoryResponse getById(int id) {
		return categoryService.getById(id);
	}
	@DeleteMapping("/delete")
	public DeleteCategoryResponse deleteCategory(DeleteCategoryRequest deleteCategoryRequest) {
		return categoryService.deleteCategory(deleteCategoryRequest);
	}
	@PutMapping("/update")
	public UpdateCategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest) {
		return categoryService.updateCategory(updateCategoryRequest);
	}
}
