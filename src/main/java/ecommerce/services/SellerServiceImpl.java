package ecommerce.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.entities.Product;
import ecommerce.entities.Seller;
import ecommerce.repository.OrderDetailsRepository;
import ecommerce.repository.ProductRepository;
import ecommerce.repository.SellerRepository;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

	@Autowired private SellerRepository sellerRepository;
	
	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private OrderDetailsRepository orderRepo;
	@Override
	public void registerSeller(Seller seller) {
		
		sellerRepository.save(seller);
	}

	@Override
	public List<Seller> allSellers() {
		
		return sellerRepository.findAll();
	}

	@Override
	public Seller findById(int id) {
		
		return sellerRepository.getById(id);
	}

	@Override
	public Seller validate(String email, String pwd) {
		Seller seller=sellerRepository.findByEmail(email);
		if(seller!=null && seller.getPwd().equals(pwd)) {
			return seller;
		}
		return null;
	}

	@Override
	public void deleteSeller(int id) {
		
		Seller seller=sellerRepository.getById(id);
		List<Product>products= prodRepo.findAllBySeller(seller);
		int n=orderRepo.deleteAllByProduct(products);
		prodRepo.deleteAll(products);
		sellerRepository.delete(seller);
		
		
		
	}

}
