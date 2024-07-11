package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 22457
 */

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    @GetMapping("/adminList")
    public Result listAdmin() {
        List<Admin>admins = adminService.listAdmin();
        return Result.success(admins);
    }

    @GetMapping("/page")
    public Result page(AdminPageRequest adminPageRequest){
        return Result.success(adminService.page(adminPageRequest));
    }

    @PostMapping("/addAdmin")
    public Result addAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
        return Result.success();
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public Result deleteAdmin(@PathVariable Integer id){
        adminService.deleteAdmin(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }

    @PutMapping("/updateAdmin")
    public Result updateAdmin(@RequestBody Admin admin){
        adminService.updateAdmin(admin);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request){
        return Result.success(adminService.login(request));
    }

}
