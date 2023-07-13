package com.masai.Service;

import java.util.List;

import com.masai.Exception.ProductException;
import com.masai.entities.Product;

public interface ProductService {
	public Product addProduct(Product p) throws ProductException;

	public List<Product> getAllProduct() throws ProductException;
}
