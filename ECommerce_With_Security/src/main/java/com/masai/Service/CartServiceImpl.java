package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CartException;
import com.masai.entities.Cart;
import com.masai.entities.Product;
import com.masai.entities.User;
import com.masai.repo.CartRepo;
import com.masai.repo.ProductRepo;
import com.masai.repo.UserRepo;

@Service

public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepo cr;
	@Autowired
	private UserRepo ur;
	@Autowired
	private ProductRepo pr;

	@Override
	public List<Product> addProduct(int id,int id2) throws CartException {
		// TODO Auto-generated method stub
		Optional<User> user=ur.findById(id2);
		if(!user.isPresent()) {
			throw new CartException("User not found");
		}
		if(user.get().getCart()==null) {
			Cart c=new Cart();
			c.setProduct(new ArrayList<>());
			c.setUser(user.get());
			Optional<Product> p=pr.findById(id);
			if(p==null) {
				throw new CartException("Product Not found");
				
			}
			List<Product> list=c.getProduct();
			list.add(p.get());
			c.setProduct(list);
			 cr.save(c);
			 return list;
		}
		return null;
		
	}

}
