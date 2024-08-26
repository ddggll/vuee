package com.example.springboot.service.impl;

import com.example.springboot.controller.request.SitePageRequest;

import com.example.springboot.entity.Site;
import com.example.springboot.mapper.SiteMapper;
import com.example.springboot.service.ISiteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 22457
 */
@Service
public class SiteService implements ISiteService {
    @Autowired
    SiteMapper siteMapper;

    @Override
    public PageInfo<Site> page(SitePageRequest sitePageRequest){
        PageHelper.startPage(sitePageRequest.getPage(), sitePageRequest.getSize());
        List<Site> sites = siteMapper.listByCondition(sitePageRequest);
        return new PageInfo<>(sites);
    }
}
