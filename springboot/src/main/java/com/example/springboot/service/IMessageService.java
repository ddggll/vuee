package com.example.springboot.service;

import com.example.springboot.controller.request.MessagePageRequest;
import com.example.springboot.entity.Application;
import com.example.springboot.entity.Message;
import com.github.pagehelper.PageInfo;

public interface IMessageService {
    PageInfo<Message> page(MessagePageRequest messagePageRequest);

    void deleteMessage(Integer id);

    void updateMessage(Message message);

    Message getById(Integer id);

    void add(Message message);
}
