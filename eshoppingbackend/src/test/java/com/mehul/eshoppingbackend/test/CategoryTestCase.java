package com.mehul.eshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mehul.eshoppingbackend.dao.CategoryDAO;
import com.mehul.eshoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mehul.eshoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	/*
	 * @Test public void testCaseCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Mobile");
	 * category.setDescription("This is some description for mobile");
	 * category.setImageURL("CAT_3.png");
	 * 
	 * assertEquals("Successfully added a category inside the table", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("Successfully fetched a single category from the table!",
	 * "Mobile", category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * category.setName("SmartPhone");
	 * 
	 * assertEquals("Successfully fetched a single category from the table!", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("Successfully fetched a single category from the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully fetched the list of categories from the table!",
	 * 2, categoryDAO.list().size());
	 * 
	 * }
	 */

	@Test
	public void testCRUDCategory() {

		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for laptop");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		//fetching and update the category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully fetched a single category from the table!", true, categoryDAO.update(category));
		
		
		// delete the category
		
		assertEquals("Successfully fetched a single category from the table!", true, categoryDAO.delete(category));
		
		
		//fetching the list of categories
		
		assertEquals("Successfully fetched the list of categories from the table!", 1, categoryDAO.list().size());
		
		
	}

}
