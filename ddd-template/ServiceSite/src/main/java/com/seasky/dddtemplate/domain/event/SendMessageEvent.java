package com.seasky.dddtemplate.domain.event;

import com.seasky.core.common.SpringContainer;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

/**
 * 定义一个发送消息的event
 *
 */
@Service
public class SendMessageEvent extends ApplicationEvent {
    String message; // 消息内容
    public String getMessage(){
        return this.message;
    }

    String user;
    public String getUser(){
        return this.user;
    }

    public SendMessageEvent() {
        super("");
    }

    SendMessageEvent(String message,String  user){
        super(message);
        this.message = message;
        this.user = user;
    }

    /**
     * 发布消息
     */
    public void send(String message, String  user){
        ApplicationEvent event = new SendMessageEvent(message, user);
        SpringContainer.getContainer().publishEvent(event);
    }

}