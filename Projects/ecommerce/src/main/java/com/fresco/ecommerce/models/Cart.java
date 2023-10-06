package com.fresco.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId")
	private Integer cartId;

	@Column(name = "totalAmount")
	private Double totalAmount;


	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="userId")
	private User user;



	/*  @OneToMany(mappedBy = "cart",
			  fetch = FetchType.EAGER,
	 cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	  private List<CartProduct> cartProducts;

	  */




	@OneToMany(fetch = FetchType.EAGER,
			cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "cartId")
	private List<CartProduct> cartProducts;

	public Cart() {
		super();
	}

	public Cart(Double totalAmount) {
		super();
		this.totalAmount = totalAmount;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}


	// add convenience methods for bi-directional relationship


	/*
	 * public void add(CartProduct tempProduct){ if(cartProducts == null){
	 * cartProducts = new ArrayList<>(); }
	 *
	 * cartProducts.add(tempProduct); tempProduct.setCart(this); }
	 */


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalAmount=" + totalAmount + ", user=" + user.getUserId() + ", cartProducts="
				+ cartProducts + "]";
	}






}
