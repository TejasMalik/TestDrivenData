package com.dxc.pms.dao;

import java.util.List;

import com.dxc.pms.model.Product;

public interface ProductDAO {
		public Product getProduct(int productId);
		public List<Product> getAllProducts();
		public void addProduct(Product product);
		public void deleteProduct(int productId);
		public void updateProduct(Product product);
		public boolean isProductExists(int productId);
}
