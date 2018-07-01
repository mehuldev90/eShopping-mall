package com.mehul.eshoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mehul.eshoppingbackend.dao.ProductDAO;
import com.mehul.eshoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * fetching single product
	 */
	@Override
	public Product get(int productId) {

		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));

	}

	@Override
	public List<Product> list() {
		
		return sessionFactory
				.getCurrentSession()
						.createQuery("FROM Product" , Product.class)
									.getResultList();

	}

	@Override
	public boolean add(Product product) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProduct() {
		
		String selectActiveProducts = "FROM Product WHERE active = :active";
		
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts,Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory,Product.class)
						.setParameter("active", true)
							.setParameter("categoryId", categoryId)
								.getResultList();
		
	}
	
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id",Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
	}

	@Override
	public List<Product> listMostViewedProducts() {
		// TODO Auto-generated method stub
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE views >= :view", Product.class)
						.setParameter("view", 2)
							.getResultList();
	}


}
