package com.kodlamaio.northwind.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data  // getter ve settter
@Table(name="products")
public class Product {
   @Column(name="id")
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   
   @Column(name="name")
   private String name;
   
   @Column(name="unitPrice")
   private double unitPrice;
   
   @Column(name="unitsInStock")
   private int  unitsInStock;
   
   
   @ManyToOne
   @JoinColumn(name="category_id")
   private Category category;  // one to many kategori one product fazla
   
   
   
   
   
}
