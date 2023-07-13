package com.masai.Service;

import java.util.List;

import com.masai.Exception.CartException;
import com.masai.entities.Product;

public interface CartService {
	
	public List<Product> addProduct(int id,int id2) throws CartException;
}	
