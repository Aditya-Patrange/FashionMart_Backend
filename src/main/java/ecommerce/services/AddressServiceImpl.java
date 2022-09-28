package ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entities.Address;
import ecommerce.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired AddressRepository addressRepository;
	
	@Override
	public Address saveAddress(Address address) {
		
		return addressRepository.save(address);
	}

	@Override
	public Address findAddress(int id) {
		
		return addressRepository.getById(id);
	}

}
