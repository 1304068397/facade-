package com.seasky.dddtemplate.interfaces.controller.test;


import com.seasky.core.ddd.test.BaseCmdTestCase;
import com.seasky.dddtemplate.dto.test.TestCmd;
import com.seasky.dddtemplate.infrastructure.dataobject.po.TestPo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例tc
 *
 * @author XueYawei
 * @date 2020/12/08
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TestCmdTc extends BaseCmdTestCase<TestCmd> {

    private static final String TEST_METHOD = "创建用户";

    /**
     * 无参构造
     */
    public TestCmdTc(){super(TEST_METHOD);}

    /**
     * 有参构造
     *
     * @param testEnvironment     示例环境
     * @param expectExceptionType 预期的异常类型
     */
    public <exception extends Exception> TestCmdTc(String testEnvironment, exception expectExceptionType){
        super(TEST_METHOD,testEnvironment,expectExceptionType);
    }



    private Map<TestPo,Integer> exceptTestPoList = new HashMap<>();


}
