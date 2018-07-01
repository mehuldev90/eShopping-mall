package com.mehul.eshoppingbackend.dao;

import java.util.List;

import com.mehul.eshoppingbackend.dto.Address;
import com.mehul.eshoppingbackend.dto.Cart;
import com.mehul.eshoppingbackend.dto.User;

public interface UserDAO {
	
	//add a user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	//alternative
	Address getBillingAddress(int userId);
	
	List<Address> listShippingAddressses(int userId);
	
	//Address getBillingAddress(User user);
	
	//List<Address> listShippingAddressses(User user);
	

}
