package com.mehul.eshoppingmall.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehul.eshoppingbackend.dao.CartLineDAO;
import com.mehul.eshoppingbackend.dao.ProductDAO;
import com.mehul.eshoppingbackend.dto.Cart;
import com.mehul.eshoppingbackend.dto.CartLine;
import com.mehul.eshoppingbackend.dto.Product;
import com.mehul.eshoppingmall.model.UserModel;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ProductDAO productDAO;
	
	private Cart getCart() {
		
		return ((UserModel)session.getAttribute("userModel")).getCart();
	
	}
	
	//returns the entire cart lines
	
	public List<CartLine> getCartLines(){
		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());
	}

	public String manageCartLine(int cartLineId, int count) {
		
		// fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}
		else
		{
			Product product = cartLine.getProduct();
			
			double oldTotal = cartLine.getTotal();
			//checking if the product quantity is available
			if(product.getQuantity() < count) {
				return "result=unavailable";
			}
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			cartLineDAO.update(cartLine);
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			return "result=Updated";
			
		}
		
	}

	public String deleteCartLine(int cartLineId) {
		
		//fetch the cartline
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}
		else
		{
			// update the cart
			
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			
			cart.setCartLines(cart.getCartLines());
			
			cartLineDAO.updateCart(cart);
			
			//remove the cart
			
			cartLineDAO.delete(cartLine);
			
			return "result=deleted";
		}
		
	}

	public String addCartLine(int productId) {
		
		String response = null;
		
		//get the cart of users using session
		
		Cart cart = this.getCart();
		
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine == null) {
			// add a new cartline
			cartLine = new CartLine();
			
			//fetch the product
			Product product = productDAO.get(productId);
			
			cartLine.setCartId(cart.getId());
			
			cartLine.setProduct(product);
			
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			response = "redirect=added";
			
		}
		else
		{
			// check if the cartline reached maximum i.e. 3
			if(cartLine.getProductCount() < 3)
			{
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
				
			}
			else
			{
				response = "result=maximum";
			}
			
		}
		
		return response;
		
	}

}
