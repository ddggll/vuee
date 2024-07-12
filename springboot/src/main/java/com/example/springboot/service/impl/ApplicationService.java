package com.example.springboot.service.impl;

import com.example.springboot.controller.request.ApplicationPageRequest;
import com.example.springboot.entity.Application;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.ApplicationMapper;
import com.example.springboot.service.IApplicationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22457
 */
@Service
public class ApplicationService implements IApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    @Override
    public PageInfo<Application> page(ApplicationPageRequest applicationPageRequest) {
        PageHelper.startPage(applicationPageRequest.getPage(), applicationPageRequest.getSize());
        List<Application> applications = applicationMapper.listByCondition(applicationPageRequest);
        return new PageInfo<>(applications);

    }
}
