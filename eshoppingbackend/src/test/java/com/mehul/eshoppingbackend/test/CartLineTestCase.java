package com.mehul.eshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mehul.eshoppingbackend.dao.CartLineDAO;
import com.mehul.eshoppingbackend.dao.ProductDAO;
import com.mehul.eshoppingbackend.dao.UserDAO;
import com.mehul.eshoppingbackend.dto.Cart;
import com.mehul.eshoppingbackend.dto.CartLine;
import com.mehul.eshoppingbackend.dto.Product;
import com.mehul.eshoppingbackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mehul.eshoppingbackend");
		context.refresh();
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAddNewCartLine() {
		
		//1. By getting the user
		user = userDAO.getByEmail("mehulmaldahiyar@gmail.com");
		
		//2. fetch the cart
		cart = user.getCart();
		
		//3. get the product
		product = productDAO.get(66);
		
		//4. create the new cart line
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine",true, cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		
		cart.setCartLines(cart.getCartLines() + 1);
		
		
		assertEquals("Failed to update the cart",true, cartLineDAO.updateCart(cart));
		
	}

}
