package com.masai.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CartException;
import com.masai.Exception.OrderException;
import com.masai.Service.OrderService;
import com.masai.Service.OrderServiceImpl;
import com.masai.model.Orders;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	private OrderService orService;
	
	
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> addOrderController (@RequestParam Integer customerId) throws OrderException, CartException{
		
		Orders addOr= orService.addOrder(customerId);
		
		return new ResponseEntity<Orders>(addOr,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/orders")
	public ResponseEntity<Orders> updateOrderController (@RequestBody Orders order) throws OrderException{
		
		Orders updateOr= orService.updateOrder(order);
		
		return new ResponseEntity<Orders>(updateOr, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<String> deleteOrderController (@PathVariable ("orderId") Integer orderId ) throws OrderException{
		
		String deleteOr= orService.removeOrder(orderId);
		
		return new ResponseEntity<String>(deleteOr,HttpStatus.OK);
	}
	
	@GetMapping("/ordersId/{orderId}")
	public ResponseEntity<Orders> getOrderByIdController(@PathVariable ("orderId") Integer orderId) throws OrderException{
		
		Orders getOr= orService.viewOrderById(orderId);
		
		return new ResponseEntity<Orders> (getOr,HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> allOrderController () throws OrderException{
		
		List<Orders> allOr= orService.AllOrder();
		
		return new ResponseEntity<List<Orders>>(allOr,HttpStatus.OK);
	}
	
	
	
}
