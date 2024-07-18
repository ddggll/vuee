package com.example.springboot.controller;


import com.example.springboot.common.Result;
import com.example.springboot.controller.request.ApplicationPageRequest;
import com.example.springboot.entity.Application;
import com.example.springboot.service.IApplicationService;
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
    private IApplicationService applicationService;

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

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        applicationService.deleteApplication(id);
        return Result.success();
    }
}
