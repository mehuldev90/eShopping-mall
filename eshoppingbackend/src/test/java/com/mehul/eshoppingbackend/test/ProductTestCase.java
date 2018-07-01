package com.mehul.eshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mehul.eshoppingbackend.dao.ProductDAO;
import com.mehul.eshoppingbackend.dto.Product;



public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mehul.eshoppingbackend");
		context.refresh();

		productDAO =  (ProductDAO) context.getBean("productDAO");
	}
	/*
	@Test
	public void testCRUDProduct() {

		product = new Product();
		product.setName("Oppo F5");
		product.setBrand("Oppo");
		product.setDescription("This is some description for Oppo F5");
		product.setUnitPrice(20000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Successfully added a product inside the table", true, productDAO.add(product));
		
		product = new Product();
		product.setName("Honor 7x");
		product.setBrand("Huawei");
		product.setDescription("This is some description for Honor 7x");
		product.setUnitPrice(13000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Successfully added a product inside the table", true, productDAO.add(product));
		
		
		//fetching and update the category
		product = productDAO.get(2);
		product.setName("Honor 7x Update");
		assertEquals("Successfully fetched aand update the single product in the table!", true, productDAO.update(product));
		
		
		// delete the category
		
		assertEquals("Successfully deleted single product from the table!", true, productDAO.delete(product));
		
		
		//fetching the list of categories
		
		assertEquals("Successfully fetched the list of products from the table!", 4, productDAO.list().size());
		
		
	}*/
	
	@Test
	public void testListActiveProduct() {
		
		assertEquals("Something went wrong while fetching the list of products!", 4, productDAO.listActiveProduct().size());
		
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		
		assertEquals("Something went wrong while fetching the list of products!", 3, productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!", 1, productDAO.listActiveProductsByCategory(1).size());
		
	}
	
	@Test
	public void testGetLatestActiveProducts() {
		
		assertEquals("Something went wrong while fetching the list of products!", 4, productDAO.getLatestActiveProducts(4).size());
	}
}
