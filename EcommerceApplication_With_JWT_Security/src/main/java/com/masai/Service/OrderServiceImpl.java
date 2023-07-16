package com.masai.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.Exception.CartException;
import com.masai.Exception.OrderException;
import com.masai.Exception.UserException;
import com.masai.Repository.CartRepository;
import com.masai.Repository.CustomerRepo;
import com.masai.Repository.OrderRepository;
import com.masai.Repository.UserRepo;
import com.masai.model.Address;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.model.Product;
import com.masai.model.ProductDTO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@Autowired
	private UserRepo userRepo;
	
	

	@Override
	public Orders addOrder(Integer customerId) throws OrderException, CartException {
		
		Orders newOrder = new Orders();
		
		Optional<Customer> loggedCus= customerRepo.findById(customerId);
		
			Optional<Cart> cart= cartRepository.findById(customerId);
			
			Cart cartDetailes= cart.get();
			
			
			
			List<Product> list= cartDetailes.getProduct();
			
			if(list.isEmpty()) {
				throw new UserException("Add products to cart first");
			}
			
			List<ProductDTO> listDTO= new ArrayList<>();
			
			for(Product p: list) {
				ProductDTO pDTO= new ProductDTO();
				
				pDTO.setProductId(p.getProductId());
				pDTO.setProductName(p.getProductName());
				pDTO.setPrice(p.getPrice());
				pDTO.setDescription(p.getDescription());
				pDTO.setQuantity(p.getQuantity());
				
				listDTO.add(pDTO);
				
			}
			
			cartDetailes.setProduct(null);
			cartRepository.save(cartDetailes);
			
			newOrder.setOrderDate(LocalDate.now());
			newOrder.setOrderStatus("Order Confirm");
			newOrder.setProductList(listDTO);
			newOrder.setCustomer(loggedCus.get());
			newOrder.setAddress(loggedCus.get().getAddress());
			
			return orderRepository.save(newOrder);
			
		}
		
		
		
	
		
		
		

	@Override
	public Orders updateOrder(Orders order) throws OrderException {
		
		
		Optional<Orders> or = orderRepository.findById(order.getOrderId());

		if (or.isPresent()) {

			orderRepository.save(order);

		} else {
			throw new OrderException("Order does not exist with this order id : " + order.getOrderId());
		}

		return order;
	}

	
	
	@Override
	public String removeOrder(Integer orderId) throws OrderException {

	    
	        Optional<Orders> order = orderRepository.findById(orderId);
	        
	        Integer cusId= order.get().getCustomer().getCustomerId();
	        
	        Customer customer= order.get().getCustomer();
	        
	        List<Orders> orderList= customer.getOrders();
	        
	        for (Iterator<Orders> iterator = orderList.iterator(); iterator.hasNext();) {
	            Orders or = iterator.next();
	            if (or.getOrderId() == orderId) {
	                iterator.remove();
	                break;
	            }
	        }
	        
	        customer.setOrders(orderList);
	        customerRepo.save(customer);
	        
	        orderRepository.delete(order.get());
	        return "Order deleted !";
	   
	}

	
	@Override
	public Orders viewOrderById(Integer orderId) throws OrderException {
		Orders or = orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderException("Order does not exist with id : " + orderId));

		return or;
	}

	@Override
	public List<Orders> AllOrder() throws OrderException {

		List<Orders> allOrders = orderRepository.findAll();

		if (allOrders.isEmpty()) {
			throw new OrderException("There is No Order in Database");
		}

		return allOrders;
	}

	

}
