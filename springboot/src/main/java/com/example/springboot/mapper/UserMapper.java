package com.example.springboot.mapper;

import com.example.springboot.controller.request.UserPageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.springboot.entity.user;

import java.util.List;

@Mapper
public interface UserMapper {

    //@Select("select * from user")
    List<user> list();


    List<user> listByCondition(UserPageRequest userPageRequest);

    void addAdmin(user user);

    user getById(Integer id);

    void updateAdmin(user user);

    void deleteAdmin(Integer id);
}
