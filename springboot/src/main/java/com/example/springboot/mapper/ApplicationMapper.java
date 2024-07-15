package com.example.springboot.mapper;

import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.ApplicationPageRequest;
import com.example.springboot.entity.Application;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    List<Application> listByCondition(ApplicationPageRequest applicationPageRequest);

    Application getById(Integer id);


    void handleApplication(Application application);
}
