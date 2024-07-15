package com.example.springboot.service;

import com.example.springboot.controller.request.ApplicationPageRequest;
import com.example.springboot.entity.Application;
import com.github.pagehelper.PageInfo;

/**
 * @author 22457
 */
public interface IApplicationService {

    PageInfo<Application> page(ApplicationPageRequest applicationPageRequest);


    Application getById(Integer id);

    void handleApplication(Application application);
}
