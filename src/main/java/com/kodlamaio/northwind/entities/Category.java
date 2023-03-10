package com.kodlamaio.northwind.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data  // getter ve setter
@Table(name="categories")
public class Category {
	
	
	   @Column(name="id")
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private int id;
	   
	   @Column(name="name")
	   private String name;
	  
	   
	   
	   @OneToMany(mappedBy = "category",cascade = CascadeType.DETACH)
	   private List<Product> products;
	   
}


