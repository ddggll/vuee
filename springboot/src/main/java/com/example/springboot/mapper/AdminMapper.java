package com.example.springboot.mapper;

import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author 22457
 */
@Mapper
public interface AdminMapper {

    List<Admin> listAdmin();

    List<Admin> listByCondition(AdminPageRequest adminPageRequest);

    void addAdmin(Admin admin);

    void deleteAdmin(Integer id);

    Admin getById(Integer id);

    void updateAdmin(Admin admin);
}
