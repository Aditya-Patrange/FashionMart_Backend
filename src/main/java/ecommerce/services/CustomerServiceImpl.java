package ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entities.Customer;
import ecommerce.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired private CustomerRepository customerRepository;

	@Override
	public void registerCustomer(Customer cust) {
		
		customerRepository.save(cust);
	}

	@Override
	public List<Customer> allCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int id) {
		
		return customerRepository.getById(id);
	}

	@Override
	public Customer validate(String email, String pwd) {
		Customer cc=customerRepository.findByEmail(email);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	@Override
	public boolean verifyUserId(String email) {
		
		return customerRepository.findByEmail(email)!=null;
	}

	@Override
	public void updateProfile(Customer cust) {
		
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(findById(cust.getId()).getPwd());
		}
		customerRepository.save(cust);	
	}
	
}
