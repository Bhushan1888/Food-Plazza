package com.dao;

import java.util.List;

import com.pojo.Cart;

public interface CartDao {

	boolean addcart(Cart c);
	List<Cart>Showcart(String emailId);
	boolean deleteCart(int cartId);
	boolean clearCart(String emailId);
	boolean searchCart(String foodName);
}
