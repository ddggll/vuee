package com.example.springboot.service;

import com.example.springboot.controller.UserController;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.user;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Objects;

public interface IUserService {

    List<user> list();

    PageInfo<user> page(UserPageRequest userPageRequest);

    void addAdmin(user user);

    user getById(Integer id);

    void updateAdmin(user user);

    void deleteAdmin(Integer id);
}
