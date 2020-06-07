package com.dxc.pms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dxc.pms.model.Product;
import com.dxc.pms.util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Product product = (Product) session.get(Product.class, productId);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		List<Product> list = session.createQuery("FROM Product").list();
		return list;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		System.out.println(product.getProductName() + " saved successfully");

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Product product = getProduct(productId);
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product);
		transaction.commit();
		session.close();
		System.out.println(product.getProductName() + " deleted successfully");

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Product oldProduct = (Product) session.get(Product.class, product.getProductId());
		oldProduct.setProductName(product.getProductName());
		oldProduct.setQuantityOnHand(product.getQuantityOnHand());
		oldProduct.setPrice(product.getPrice());
		transaction.commit();
		session.close();

	}

	@Override
	public boolean isProductExists(int productId) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Product product = (Product) session.get(Product.class, productId);

		if (product == null) {
			return false;
		}
		return true;
	}

}
