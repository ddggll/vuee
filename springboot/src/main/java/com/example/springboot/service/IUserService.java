package com.example.springboot.service;

import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.entity.user;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserService {

    List<user> list();

    PageInfo<user> page(AdminPageRequest adminPageRequest);

    void addAdmin(user user);

    user getById(Integer id);

    void updateAdmin(user user);

    void deleteAdmin(Integer id);
}
