package com.dxc.pms.dao;

import java.util.List;

import com.dxc.pms.model.Product;

import junit.framework.TestCase;

public class ProductDAOImplTest extends TestCase {

	ProductDAOImpl impl;

	protected void setUp() throws Exception {
		impl = new ProductDAOImpl();
	}

	public void testGetProduct() {
		Product product = new Product(5, "Something", 12, 22);
		impl.addProduct(product);
		Product product2 = impl.getProduct(product.getProductId());
		
		assertEquals(product, product2);
		impl.deleteProduct(product.getProductId());
		


	}

	public void testGetAllProducts() {
		Product product = new Product(1, "Something", 12, 22);
		impl.addProduct(product);
		List<Product> allProduct = impl.getAllProducts();

		assertNotSame(allProduct.size() + 1, allProduct.size());
		impl.deleteProduct(product.getProductId());

	}

	public void testAddProduct() {
		Product product = new Product(2, "Something", 12, 22);
		List<Product> allProduct1 = impl.getAllProducts();
		impl.addProduct(product);
		List<Product> allProduct2 = impl.getAllProducts();
		assertNotSame(allProduct1.size(), allProduct2.size());
		impl.deleteProduct(product.getProductId());
	}

	public void testDeleteProduct() {
		Product product = new Product(3, "Something", 12, 22);
		impl.addProduct(product);
		List<Product> allProduct1 = impl.getAllProducts();
		impl.deleteProduct(product.getProductId());
		List<Product> allProduct2 = impl.getAllProducts();

		assertNotSame(allProduct1.size(), allProduct2.size());

	}

	public void testUpdateProduct() {
		Product product = new Product(4, "Something", 12, 22);
		Product product2 = new Product(4, "Some", 10, 23);

		impl.addProduct(product);
		impl.updateProduct(product2);

		assertNotSame(product, product2);
		impl.deleteProduct(product.getProductId());

	}
	
	public void testIsProductExists() {
		
		Product product = new Product(7, "Something", 12, 22);
		impl.addProduct(product);
		assertEquals(true, impl.isProductExists(product.getProductId()));
		impl.deleteProduct(product.getProductId());

	}


}
