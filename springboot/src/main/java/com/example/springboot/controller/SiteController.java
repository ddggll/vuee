package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.SitePageRequest;
import com.example.springboot.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 22457
 */

@Controller
@CrossOrigin
@RestController
@RequestMapping("/site")
public class SiteController {
    @Autowired
    private ISiteService siteService;

    @GetMapping("/page")
    public Result page(SitePageRequest sitePageRequest){
        return Result.success(siteService.page(sitePageRequest));
    }

}
