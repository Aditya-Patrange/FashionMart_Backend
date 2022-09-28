package ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entities.Admin;
import ecommerce.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired AdminRepository adminRepository;

	@Override
	public Admin validate(String email, String pwd) {
		
		Optional<Admin> admin=adminRepository.findById(email);
		if(admin.isPresent() && admin.get().getPwd().equals(pwd)) {
			return admin.get();
		}
		return null;
	}

	@Override
	public void updateAdmin(Admin admin) {
		if(admin.getPwd().equals("") || admin.getPwd()==null) {
			admin.setPwd(adminRepository.getById(admin.getEmail()).getPwd());
		}
		adminRepository.save(admin);		
	}

	@Override
	public long countAdmin() {
		
		return adminRepository.count();
	}

}
