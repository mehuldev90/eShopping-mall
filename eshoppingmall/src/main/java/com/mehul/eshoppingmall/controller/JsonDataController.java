package com.mehul.eshoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mehul.eshoppingbackend.dao.ProductDAO;
import com.mehul.eshoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsList() {
		return productDAO.list();
		
	}
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProduct();
		
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id){
		
		return productDAO.listActiveProductsByCategory(id);
		
	}
	
	@RequestMapping("/most/viewed/products")
	@ResponseBody
	public List<Product> getMostViewedProducts(){
		return productDAO.listMostViewedProducts();
	}
}
