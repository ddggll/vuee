package com.example.springboot.service;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 22457
 */
public interface IAdminService {

    List<Admin> listAdmin();

    PageInfo<Admin> page(AdminPageRequest adminPageRequest);

    void addAdmin(Admin admin);

    void deleteAdmin(Integer id);

    Admin getById(Integer id);

    void updateAdmin(Admin admin);

    LoginDTO login(LoginRequest request);
}
