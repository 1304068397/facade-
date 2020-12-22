package com.seasky.dddtemplate.domain.event;

import com.seasky.core.common.SpringContainer;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

@Service
public class DeleteTestEvent extends ApplicationEvent {

    public DeleteTestEvent() {
        super("");
    }

    DeleteTestEvent(String userCode){
        super(userCode);
    }

    /**
     * 发布消息
     */
    public void DeleteVerify(String userCode){
        ApplicationEvent event = new DeleteTestEvent(userCode);
        SpringContainer.getContainer().publishEvent(event);
    }

}
