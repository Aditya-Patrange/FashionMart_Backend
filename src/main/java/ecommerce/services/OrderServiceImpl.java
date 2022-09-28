package ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entities.Customer;
import ecommerce.entities.Order;
import ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
		
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		
		return orderRepository.findAll();
	}

	@Override
	public List<Order> getCustomerOrders(Customer customer) {
		
		return orderRepository.findByCustomer(customer);
	}

	@Override
	public Order findById(int id) {
		
		return orderRepository.getById(id);
	}

	
}
