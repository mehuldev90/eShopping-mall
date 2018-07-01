package com.mehul.eshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mehul.eshoppingbackend.dao.UserDAO;
import com.mehul.eshoppingbackend.dto.Address;
import com.mehul.eshoppingbackend.dto.Cart;
import com.mehul.eshoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mehul.eshoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	
	/*@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Virat");
		user.setLastName("Kohli");
		user.setEmail("vk@gmail.com");
		user.setContactNumber("0123456798");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("104/B, Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Bangalore Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		// link the address with user using userid
		address.setUserId(user.getId());
		
		assertEquals("Failed to add Address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			//create a cart for this user
			cart = new Cart();
			
			cart.setUser(user);
			
			assertEquals("Failed to add Cart!", true, userDAO.addCart(cart));
			
			
			//add a shipping address for this user
			
			address = new Address();
			address.setAddressLineOne("204/B, Jadoo Society, Krissh Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			//set shipping to true
			address.setShipping(true);
			
			// link it with the user
			address.setUserId(user.getId());
			
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
			
		}
		
	}*/
	
	
	//***************
	/*@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Virat");
		user.setLastName("Kohli");
		user.setEmail("vk@gmail.com");
		user.setContactNumber("0123456798");
		user.setRole("USER");
		user.setPassword("123456");
		
		if(user.getRole().equals("USER")) {
			
			//create a cart for this user
			cart = new Cart();
			
			cart.setUser(user);
			
			//attach cart
			
			user.setCart(cart);
			
		}
		
		//add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
	}*/
	//***************
	/*
	@Test
	public void testUpdateCart() {
		
		// fetch the user by its email
		
		user = userDAO.getByEmail("vk@gmail.com");
		
		// get the cart of the user
		
		cart = user.getCart();
		
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
		
	}*/
	
	//***************
	/*
	@Test
	public void testAddAddress() {
		
		// need to add user
		
		user = new User();
		user.setFirstName("Virat");
		user.setLastName("Kohli");
		user.setEmail("vk@gmail.com");
		user.setContactNumber("0123456798");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		//need to add the address
		address = new Address();
		address.setAddressLineOne("104/B, Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Bangalore Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//attach the address to the user
		address.setUser(user);
		
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		//add the shipping address
		
		address = new Address();
		address.setAddressLineOne("204/B, Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		//set shipping to true
		address.setShipping(true);
		
		// attach the address to the user
		
		address.setUser(user);
		
		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
		
	}*/
	/*
	@Test
	public void testAddAddress() {
		
		//get the user
		user = userDAO.getByEmail("vk@gmail.com");
		
		//add the shipping address
		
		address = new Address();
		address.setAddressLineOne("304/B, Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("400001");
		//set shipping to true
		address.setShipping(true);
			
		// attach the address to the user
		
		address.setUser(user);
		
		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
	}*/
	
	//---------------------------
	
	@Test
	public void testGetAddress() {
		
		user = userDAO.getByEmail("mehulmaldahiyar@gmail.com");
		
		assertEquals("Failed to fetch the shipping address address!", "Thane", 
				userDAO.getBillingAddress(user.getId()).getCity());
		
	}

}
