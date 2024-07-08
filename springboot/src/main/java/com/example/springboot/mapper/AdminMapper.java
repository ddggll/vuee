package com.example.springboot.mapper;

import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author 22457
 */
@Mapper
public interface AdminMapper {

//    @Select("select * from admin")
    List<Admin> listAdmin();
    List<Admin> listByCondition(AdminPageRequest adminPageRequest);

}
