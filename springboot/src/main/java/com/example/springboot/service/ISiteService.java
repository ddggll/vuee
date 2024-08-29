package com.example.springboot.service;

import com.example.springboot.controller.request.SitePageRequest;
import com.example.springboot.entity.Site;
import com.github.pagehelper.PageInfo;

public interface ISiteService {

    PageInfo<Site> page(SitePageRequest sitePageRequest);

    void deleteSite(Integer id);

    Site getById(Integer id);

    void siteUpdate(Site site);

    void siteAdd(Site site);
}
