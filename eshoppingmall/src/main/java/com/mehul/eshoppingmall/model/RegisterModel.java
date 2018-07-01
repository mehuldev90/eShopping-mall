package com.mehul.eshoppingmall.model;

import java.io.Serializable;

import com.mehul.eshoppingbackend.dto.Address;
import com.mehul.eshoppingbackend.dto.User;

public class RegisterModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private fields
	private User user;
	private Address billing;
	
	//Getters and setters
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
	
	//to string method
	
	@Override
	public String toString() {
		return "RegisterModel [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
