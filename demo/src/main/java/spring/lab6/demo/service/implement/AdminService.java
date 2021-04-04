package spring.lab6.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab6.demo.repository.AdminRepository;
import spring.lab6.demo.service.IAdminService;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean checkByUsernameAndPassword(String username, String password) {
        return adminRepository.existsAdminByUsernameAndPassword(username, password);
    }
}
