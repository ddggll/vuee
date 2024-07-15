package com.example.springboot.controller;


import com.example.springboot.common.Result;
import com.example.springboot.controller.request.ApplicationPageRequest;
import com.example.springboot.entity.Application;
import com.example.springboot.service.impl.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 22457
 */
@Controller
@CrossOrigin
@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @GetMapping("/page")
    public Result page(ApplicationPageRequest applicationPageRequest) {
        return Result.success(applicationService.page(applicationPageRequest));
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Application application = applicationService.getById(id);
        return Result.success(application);
    }

    @PutMapping("/handleApplication")
    public Result handleApplication(@RequestBody Application application) {
        applicationService.handleApplication(application);
        return Result.success();
    }





}
