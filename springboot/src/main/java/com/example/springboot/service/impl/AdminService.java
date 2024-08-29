package com.example.springboot.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;

import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.service.IAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22457
 */
@Service
public class AdminService implements IAdminService {
    private static final Logger log = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> listAdmin() {
        return adminMapper.listAdmin();
    }

    @Override
    public PageInfo<Admin> page(AdminPageRequest adminPageRequest) {
        System.out.println(adminPageRequest);
        PageHelper.startPage(adminPageRequest.getPageNum(), adminPageRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(adminPageRequest);
        return new PageInfo<>(admins);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.addAdmin(admin);
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminMapper.deleteAdmin(id);
    }

    @Override
    public Admin getById(Integer id) {
        return adminMapper.getById(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    @Override
    public LoginDTO login(LoginRequest request){
        Admin admin=null;
        try {
            admin=adminMapper.getByStudentId(request.getStudentId());
        }catch (Exception e){
            throw new ServiceException("用户名错误");
        }
        if(admin==null){
            throw new ServiceException("用户名错误");
        }
        if(!admin.getPassword().equals(request.getPassword())){
            throw new ServiceException("密码错误");
        }


//        Admin admin=adminMapper.getByNameAndPassword(request);

        LoginDTO loginDTO=new LoginDTO();
        BeanUtils.copyProperties(admin,loginDTO);
        return loginDTO;
    }

}
