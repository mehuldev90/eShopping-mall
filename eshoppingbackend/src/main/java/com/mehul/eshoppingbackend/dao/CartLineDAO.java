package com.mehul.eshoppingbackend.dao;

import java.util.List;

import com.mehul.eshoppingbackend.dto.Cart;
import com.mehul.eshoppingbackend.dto.CartLine;

public interface CartLineDAO {
	
	// the common methods
	
	public CartLine get(int id);
	
	public boolean add(CartLine cartLine);
	
	public boolean update(CartLine cartLine);
	
	public boolean delete(CartLine cartLine);
	
	public List<CartLine> list(int cartId);
	
	// business methods
	
	public List<CartLine> listAvailable(int cartId);
	
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	//update a cart
	boolean updateCart(Cart cart);
}
