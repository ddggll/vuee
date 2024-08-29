package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.SitePageRequest;
import com.example.springboot.entity.Site;
import com.example.springboot.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        siteService.deleteSite(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Site site = siteService.getById(id);
        return Result.success(site);
    }

    @PutMapping("/update")
    public Result siteUpdate(@RequestBody Site site){
        siteService.siteUpdate(site);
        return Result.success();
    }

    @PostMapping("/siteAdd")
    public Result siteAdd(@RequestBody Site site){
        siteService.siteAdd(site);
        return Result.success();
    }

}
