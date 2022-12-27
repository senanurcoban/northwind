package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.CategoryService;
import com.kodlamaio.northwind.business.requests.CreateCategoryRequest;
import com.kodlamaio.northwind.business.requests.DeleteCategoryRequest;
import com.kodlamaio.northwind.business.requests.UpdateCategoryRequest;
import com.kodlamaio.northwind.business.responses.CreateCategoryResponse;
import com.kodlamaio.northwind.business.responses.DeleteCategoryResponse;
import com.kodlamaio.northwind.business.responses.GetAllCategoryResponse;
import com.kodlamaio.northwind.business.responses.GetCategoryResponse;
import com.kodlamaio.northwind.business.responses.UpdateCategoryResponse;
import com.kodlamaio.northwind.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.northwind.dataAccess.abstracts.CategoryRepository;
import com.kodlamaio.northwind.entities.Category;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CategoryManager implements CategoryService{

	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCategoryResponse> getAllCategory() {
		List<Category> categories=categoryRepository.findAll();
		List<GetAllCategoryResponse> allCategoryResponses=new ArrayList<>();
		
		for(Category category: categories) {
			GetAllCategoryResponse response=new GetAllCategoryResponse();
			response.setId(category.getId());
			response.setName(category.getName());
			allCategoryResponses.add(response);
		}
		return allCategoryResponses;
	}

	@Override
	public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
		
		Category category=this.modelMapperService.forRequest().map(createCategoryRequest,Category.class);
		this.categoryRepository.save(category);
		CreateCategoryResponse categoryResponse=this.modelMapperService.forResponse().map(category,CreateCategoryResponse.class);
		return categoryResponse;
		
		
		/*Category category=new Category();
		category.setName(createCategoryRequest.getName());
		categoryRepository.save(category);
		
		CreateCategoryResponse createCategoryResponse=new CreateCategoryResponse();
		createCategoryResponse.setName(category.getName());
		
		return createCategoryResponse;*/
	}

	@Override
	public List<GetAllCategoryResponse> getByName(String name) {
		List<Category> categories=this.categoryRepository.getByName(name);
		List<GetAllCategoryResponse> allCategoryResponses=new ArrayList<>();
		for(Category category:categories) {
			GetAllCategoryResponse response=new GetAllCategoryResponse();
			response.setId(category.getId());
			response.setName(category.getName());
			allCategoryResponses.add(response);
		}
		return allCategoryResponses;
	}

	@Override
	public GetCategoryResponse getById(int id) {
		Category category=this.categoryRepository.findById(id).get();
		GetCategoryResponse categoryResponse=new GetCategoryResponse();
		
		categoryResponse.setId(category.getId());
		categoryResponse.setName(category.getName());
		
		return categoryResponse;
	}

	@Override
	public DeleteCategoryResponse deleteCategory(DeleteCategoryRequest deleteCategoryRequest) {
		Category category=categoryRepository.findById(deleteCategoryRequest.getId()).get();
		categoryRepository.delete(category);
		DeleteCategoryResponse deleteCategoryResponse=new DeleteCategoryResponse();
		deleteCategoryRequest.setId(category.getId());
		deleteCategoryResponse.setName(category.getName());
		return deleteCategoryResponse;
	}

	@Override
	public UpdateCategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest) {
		/*Category category=categoryRepository.findById(updateCategoryRequest.getId()).get();
		category.setId(updateCategoryRequest.getId());
		category.setName(updateCategoryRequest.getName());
		categoryRepository.save(category);
		
		UpdateCategoryResponse response=new UpdateCategoryResponse();
		response.setId(category.getId());
		response.setName(category.getName());
		return response;*/
		
		
		Category category=this.modelMapperService.forRequest().map(updateCategoryRequest,Category.class);
		this.categoryRepository.save(category);
		UpdateCategoryResponse response=this.modelMapperService.forResponse().map(category,UpdateCategoryResponse.class);
		return response;
	}
	
	

}
