package com.mehul.eshoppingmall.handler;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.mehul.eshoppingbackend.dao.UserDAO;
import com.mehul.eshoppingbackend.dto.Address;
import com.mehul.eshoppingbackend.dto.Cart;
import com.mehul.eshoppingbackend.dto.User;
import com.mehul.eshoppingmall.model.RegisterModel;

@Component
public class RegisterHandler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public RegisterModel init() {

		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {

		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {

		registerModel.setBilling(billing);
	}
	
	public String validateUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		//checking if password matches with confirm password
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			error.addMessage(new MessageBuilder()
					.error()
						.source("confirmPassword")
							.defaultText("Password doesn't match the confirm password")
								.build());;
			
			transitionValue = "failure";
		}
		
		// check the uniqueness of the email id
		
		if(userDAO.getByEmail(user.getEmail()) != null) {
			
			error.addMessage(new MessageBuilder()
					.error()
						.source("email")
							.defaultText("Email address is already used!")
								.build());;
			
			transitionValue = "failure";
		}
		
		return transitionValue;
		
	}
	
	public String saveAll(RegisterModel model) {
		
		String transitionValue = "success";
		
		//fetch the user
		User user = model.getUser();
		
		if(user.getRole().equals("USER")) {
			//create the cart for user
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//save the user
		userDAO.addUser(user);
		
		//save the billing address
		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		//saving the address
		userDAO.addAddress(billing);
		
		return transitionValue;
	}

}
