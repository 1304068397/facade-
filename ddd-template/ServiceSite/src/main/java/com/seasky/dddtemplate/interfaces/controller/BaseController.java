package com.seasky.dddtemplate.interfaces.controller;


/**
 * 控制器基础抽象类
         * @author bandi
        * */
public abstract class BaseController {



    private Long userId;
    /**
     * 获取当前用户id
     * */
    protected Long getUserId(){
        if(userId==null||userId==0) {

            this.userId= new Long(1);

        }
        return userId;
    }
}
