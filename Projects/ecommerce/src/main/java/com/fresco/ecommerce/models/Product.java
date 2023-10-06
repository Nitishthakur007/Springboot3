package com.fresco.ecommerce.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private Integer productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "price")
	private Double price;


	/* private User seller; */

	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="categoryId")
	private Category category;



	public Product() {
		super();
	}


	public Product(String productName, Double price) {
		super();
		this.productName = productName;
		this.price = price;
		/*
		 * this.seller = seller; this.category = category;
		 */
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}



	/*
	 * public User getSeller() { return seller; }
	 *
	 * public void setSeller(User seller) { this.seller = seller; }
	 */


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	/*
	 * @Override public String toString() { return "Product [productId=" + 0 +
	 * ", productName=" + productName + ", price=" + price + ", seller=" +
	 * seller.getUserId() + ", category=" + category + "]"; }
	 */





}
