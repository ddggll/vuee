package com.example.springboot.service;

import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.user;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 22457
 */
public interface IAdminService {

    List<Admin> listAdmin();
    PageInfo<Admin> page(AdminPageRequest adminPageRequest);

}
