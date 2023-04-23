package com.dao;

import java.time.LocalDate;

import java.util.List;

import com.entities.Item;
import com.entities.Order;
import com.exceptions.ItemNotFoundException;
import com.exceptions.OrderNotFoundException;

public interface OrderItemDao {

	public void addOrder(Order order) throws OrderNotFoundException;
	public void createItem(Item item, int orderId) throws ItemNotFoundException;
	public void createItems(List<Item> items, int orderId) throws ItemNotFoundException;
	public void getItem(int itemId) throws ItemNotFoundException;
	public void getOrder(int orderId) throws OrderNotFoundException;
	public void getItems(LocalDate inputDate) throws ItemNotFoundException;
	
}
