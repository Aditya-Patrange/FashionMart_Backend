package ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entities.Order;
import ecommerce.entities.OrderDetails;
import ecommerce.repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderdetailService {

	@Autowired OrderDetailsRepository orderDetailsRepository;
	@Override
	public void saveOrderDetails(OrderDetails od) {
		
		orderDetailsRepository.save(od);
	}

	@Override
	public OrderDetails findById(int id) {
		
		return orderDetailsRepository.getById(id);
	}

	@Override
	public List<OrderDetails> findByOrder(Order order) {
		
		return orderDetailsRepository.findByOrder(order);
	}

}
