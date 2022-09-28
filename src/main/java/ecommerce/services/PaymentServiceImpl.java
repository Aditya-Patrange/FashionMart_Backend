package ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entities.Payment;
import ecommerce.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired PaymentRepository paymentRepository;
	
	@Override
	public Payment savePayment(Payment payment) {
		
		return paymentRepository.save(payment);
	}

	@Override
	public Payment findPaymentById(int id) {
		
		return paymentRepository.getById(id);
		
		
	}

}
