package spring.lab6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.lab6.demo.entity.Admin;
import spring.lab6.demo.service.implement.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // GET
    @GetMapping("")
    public List<Admin> getAllAdmins() {
        return adminService.getAll();
    }
}
