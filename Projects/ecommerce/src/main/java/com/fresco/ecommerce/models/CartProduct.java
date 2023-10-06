package com.fresco.ecommerce.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartproduct")
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cpId")
	private Integer cpId;

	/*
	 @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH, CascadeType.REMOVE})
	 @JoinColumn(name="cartId")
	 private Cart cart;
	 */




	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			//CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="productId")
	private Product product;

	@Column(name = "quantity")
	private Integer quantity = 1;


	@Column(name = "cartId")
	private Integer cartId;



	public CartProduct() {
		super();
	}


	public CartProduct(Integer quantity) {
		super();
		this.quantity = quantity;
	}


	public Integer getCpId() {
		return cpId;
	}


	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}


	/*
	 public Cart getCart() { return cart; }
	 public void setCart(Cart cart) { this.cart = cart; }
	 */


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getCartId() {
		return cartId;
	}


	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}





	/*
	 * @Override public String toString() { return "CartProduct [cpId=" + cpId +
	 * ", cart=" + cart.getCartId() + ", product=" + product + ", quantity=" +
	 * quantity + "]"; }
	 */


}
