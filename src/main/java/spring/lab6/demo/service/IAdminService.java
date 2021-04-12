package spring.lab6.demo.service;

import spring.lab6.demo.entity.Admin;

import java.util.List;

public interface IAdminService {
    List<Admin> getAll();
    boolean checkByUsernameAndPassword(String username, String password);
}
