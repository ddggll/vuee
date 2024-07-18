package com.example.springboot.mapper;

import com.example.springboot.controller.request.ApplicationPageRequest;
import com.example.springboot.entity.Application;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 22457
 */
@Mapper
public interface ApplicationMapper {
    List<Application> listByCondition(ApplicationPageRequest applicationPageRequest);

    Application getById(Integer id);


    void handleApplication(Application application);


    void deleteApplication(Integer id);
}
