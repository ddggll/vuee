package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.MessagePageRequest;
import com.example.springboot.entity.Message;
import com.example.springboot.mapper.MessageMapper;
import com.example.springboot.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 22457
 */
@Controller
@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private IMessageService messageService;
    @Autowired
    private MessageMapper messageMapper;

    @GetMapping("/page")
    public Result page(MessagePageRequest messagePageRequest) {
        return Result.success(messageService.page(messagePageRequest));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        messageService.deleteMessage(id);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateMessage(@RequestBody Message message){
        messageService.updateMessage(message);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Message message = messageService.getById(id);
        return Result.success(message);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Message message){
        messageService.add(message);
        return Result.success();
    }


}
