package com.example.springboot.service.impl;

import com.example.springboot.controller.request.MessagePageRequest;
import com.example.springboot.entity.Message;
import com.example.springboot.mapper.MessageMapper;
import com.example.springboot.service.IMessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22457
 */
@Service
public class MessageService implements IMessageService {
  @Autowired
  MessageMapper messageMapper;

  @Override
    public PageInfo<Message> page(MessagePageRequest messagePageRequest) {
      PageHelper.startPage(messagePageRequest.getPage(), messagePageRequest.getSize());
      List<Message> messages = messageMapper.listByCondition(messagePageRequest);
      return new PageInfo<>(messages);
    }

    @Override
     public void deleteMessage(Integer id){
        messageMapper.deleteMessage(id);
    }

    @Override
    public void updateMessage(Message message){
        messageMapper.updateMessage(message);
    }

    @Override
    public Message getById(Integer id){
      return messageMapper.getById(id);
    }

    @Override
    public void add(Message message){
        messageMapper.add(message);
    }
}
