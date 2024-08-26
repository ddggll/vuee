package com.example.springboot.mapper;

import com.example.springboot.controller.request.SitePageRequest;
import com.example.springboot.entity.Site;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 22457
 */
@Mapper
public interface SiteMapper {
    List<Site> listByCondition(SitePageRequest sitePageRequest);
}
