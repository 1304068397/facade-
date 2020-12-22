package com.seasky.dddtemplate.domain.aggregate.flow;

import lombok.Data;

@Data
public class FlowAggregate {
    private String status;
    private String userCode;
    private String flowID;

    public void submit(String userCode){
        this.userCode = userCode;
    }
}
