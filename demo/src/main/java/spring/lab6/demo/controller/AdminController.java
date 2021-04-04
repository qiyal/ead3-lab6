package spring.lab6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.lab6.demo.service.implement.AdminService;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    public boolean check(String username, String password) {
        return adminService.checkByUsernameAndPassword(username, password);
    }
}
