package com.bitwise.OnlineShoppingCart.model;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.OnlineShoppingCart.controller.OutOfStockException;

public class Cart {
	int cartSize;
	double cartValue;

	List<ProductDetails> cartItems = new ArrayList<ProductDetails>();

	public int getCartSize() {
		return cartSize;
	}

	public void setCartSize(int cartSize) {
		this.cartSize = cartSize;
	}

	public double getCartValue() {
		return cartValue;
	}

	public void setCartValue(double cartValue) {
		this.cartValue = cartValue;
	}

	public List<ProductDetails> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<ProductDetails> cartItems) {
		this.cartItems = cartItems;
	}

	public void addItem(ProductDetails pd) {
		if (inStock(pd)) {
			cartValue += Integer.parseInt(pd.getPrice());
			pd.setStock(pd.getStock() - 1);
			cartItems.add(pd);
			System.out.println(cartSize + " " + cartValue + " ");
		} else
			throw new OutOfStockException("Product out of stock");
	}

	private boolean inStock(ProductDetails pd) {
		if (pd.getStock() - 1 < 0)
			return false;
		return true;
	}

	public ProductDetails getProductByProductName(String pname) {
		for (ProductDetails pro : cartItems) {
			if (pro.getName().equals(pname)) {
				return pro;
			}
		}
		return null;
	}

	public void removeItem(ProductDetails product) {
		cartValue -= Integer.parseInt(product.getPrice());
		product.setStock(product.getStock() + 1);
		cartItems.remove(product);

	}

}
