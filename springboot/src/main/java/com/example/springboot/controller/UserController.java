package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.user;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @PostMapping("/addAdmin")
    public Result addAdmin(@RequestBody user user) {
        userService.addAdmin(user);
        return Result.success();
    }

    @PutMapping("/updateAdmin")
    public Result updateAdmin(@RequestBody user user) {
        userService.updateAdmin(user);
        return Result.success();
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public Result deleteAdmin(@PathVariable Integer id) {
        userService.deleteAdmin(id);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        user user = userService.getById(id);
        return Result.success(user);
    }

    @GetMapping("/list")
    public Result list(){
        List<user> users = userService.list();
        return Result.success(users);
    }

    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest){
        return Result.success(userService.page(userPageRequest));
    }
}
