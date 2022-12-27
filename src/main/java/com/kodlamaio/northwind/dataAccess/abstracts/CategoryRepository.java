package com.kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> getByName(String name);
}
