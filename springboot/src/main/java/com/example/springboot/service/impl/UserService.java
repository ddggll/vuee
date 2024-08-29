package com.example.springboot.service.impl;

import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.entity.user;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<user> list() {
        return userMapper.list();
    }

    @Override
    public PageInfo<user>  page(AdminPageRequest adminPageRequest) {
        PageHelper.startPage(adminPageRequest.getPageNum(), adminPageRequest.getPageSize());
        List<user> users = userMapper.listByCondition(adminPageRequest);
        return new PageInfo<>(users);
    }
    @Override
    public void addAdmin(user user) {
        userMapper.addAdmin(user);
    }

    @Override
    public user getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void updateAdmin(user user) {
        userMapper.updateAdmin(user);
    }

    @Override
    public void deleteAdmin(Integer id) {
        userMapper.deleteAdmin(id);
    }


}
