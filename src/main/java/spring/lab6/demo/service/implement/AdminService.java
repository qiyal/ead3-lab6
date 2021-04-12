package spring.lab6.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab6.demo.entity.Admin;
import spring.lab6.demo.repository.AdminRepository;
import spring.lab6.demo.service.IAdminService;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAll() {
        return adminRepository.getAdminsBy();
    }

    @Override
    public boolean checkByUsernameAndPassword(String username, String password) {
        return adminRepository.existsAdminByUsernameAndPassword(username, password);
    }
}
