package com.fresco.ecommerce.models;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	private Integer categoryId;

	@Column(name = "categoryName")
	private String categoryName;
	public Category() {
		super();
	}
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}



}
