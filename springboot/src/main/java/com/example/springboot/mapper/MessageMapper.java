package com.example.springboot.mapper;

import com.example.springboot.controller.request.MessagePageRequest;
import com.example.springboot.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 22457
 */
@Mapper
public interface MessageMapper {

    List<Message> listByCondition(MessagePageRequest messagePageRequest);

    void deleteMessage(Integer id);

    void updateMessage(Message message);

    Message getById(Integer id);
}
