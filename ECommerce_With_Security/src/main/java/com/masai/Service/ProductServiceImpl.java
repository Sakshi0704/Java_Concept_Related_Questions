package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.ProductException;
import com.masai.entities.Product;
import com.masai.repo.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo pr;
	@Override
	public Product addProduct(Product p) throws ProductException{
		// TODO Auto-generated method stub
		if(p==null) {
			throw new ProductException("Product is Empty");
		}
		return pr.save(p);
	}
	@Override
	public List<Product> getAllProduct() throws ProductException {
		// TODO Auto-generated method stub
		List<Product>pros= pr.findAll();
		if(pros.isEmpty()) {
			throw new ProductException("Products Not found");
		}
		return pros;
	}

}
