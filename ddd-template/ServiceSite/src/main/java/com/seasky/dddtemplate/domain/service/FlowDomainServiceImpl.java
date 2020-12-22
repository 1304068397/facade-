package com.seasky.dddtemplate.domain.service;

import com.seasky.dddtemplate.domain.event.DeleteTestEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class FlowDomainServiceImpl {

    @EventListener
    @Order(0)
    public void deleteTestVerify(DeleteTestEvent event) {
        // 进行删除test的校验
        System.out.println("流程收到删除事件，参数:" + event.getSource());//获取参数
    }
}
