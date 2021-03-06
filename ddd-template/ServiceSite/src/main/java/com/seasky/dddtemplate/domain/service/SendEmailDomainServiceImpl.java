package com.seasky.dddtemplate.domain.service;

import com.seasky.dddtemplate.domain.event.SendMessageEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendEmailDomainServiceImpl {

    @EventListener
    @Async
    public void send(SendMessageEvent event) {
        // 把event转成 发送邮件的聚合
        // 然后去发送消息
        System.out.println("邮件消息收到事件，参数:" + event.getMessage());//获取参数
    }
}
