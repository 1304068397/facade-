package com.seasky.dddtemplate.interfaces.controller.test;


import com.seasky.core.ddd.test.BaseQryTestCase;
import com.seasky.dddtemplate.dto.test.TestQueryQry;

public class TestQueryTc extends BaseQryTestCase<TestQueryQry> {

    private static final String TEST_METHOD = "组合条件查询用户";

    public TestQueryTc(String testEnvironment){
        super(TEST_METHOD,testEnvironment);
    }

}
