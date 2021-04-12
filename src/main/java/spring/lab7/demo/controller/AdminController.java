package spring.lab7.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.lab7.demo.entity.Admin;
import spring.lab7.demo.service.implement.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admins")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("")
    public List<Admin> getAllAdmins() {
        return adminService.getAll();
    }

    public boolean check(String username, String password) {
        return adminService.checkByUsernameAndPassword(username, password);
    }
}
