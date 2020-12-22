package com.seasky.dddtemplate.interfaces.controller.test;


import com.seasky.core.exception.DataAccessException;
import com.seasky.dddtemplate.dto.test.TestCmd;
import com.seasky.dddtemplate.infrastructure.dataobject.po.TestPo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestCmdFactory {

    /**
     * 获取测试入参对象
     *
     * @return {@link Stream< TestCmdTc >}
     */
    public static Stream<TestCmdTc> getTCStream(){
        List<TestCmdTc> saveDgjBudgetDraftTcs = new ArrayList<>();
        saveDgjBudgetDraftTcs.add(buildTestCase());
        saveDgjBudgetDraftTcs.add(buildTestCase_tow());
        return saveDgjBudgetDraftTcs.stream();
    }


    /**
     * 构建示例
     * 正常入参对象
     * @return {@link TestCmdTc}
     */
    private static TestCmdTc buildTestCase(){
        TestCmdTc testCmdTc = new TestCmdTc();
        TestCmd testCmd = new TestCmd();
        testCmd.setAge(1);
        testCmd.setCode("123");
        testCmd.setName("姓名1");
        testCmd.setSex("男");
        testCmdTc.setCmdParam(testCmd);
        testCmdTc.getExceptTestPoList().put(buildTestPo(testCmd),1);
        return testCmdTc;
    }

    /**
     * 构建示例
     * 生成异常入参对象
     * @return {@link TestCmdTc}
     */
    private static TestCmdTc buildTestCase_tow(){
        //声明你调用对应接口时,这个接口应该返回的异常类型--预期的异常类型
        DataAccessException exception =  new DataAccessException(new Throwable());
        //调用有参构造  传入 提示语 预期的异常类型 (此构造方法会将 IsPositiveCase 值赋为 false)
        TestCmdTc testCmdTc = new TestCmdTc("用户编号重复",exception);
        TestCmd testCmd = new TestCmd();
        testCmd.setAge(10);
        testCmd.setCode("001");
        testCmd.setName("姓名2");
        testCmd.setSex("男");
        testCmdTc.setCmdParam(testCmd);
        //将入参cmd对象转为po并存入集合
        testCmdTc.getExceptTestPoList().put(buildTestPo(testCmd),0);
        return testCmdTc;
    }

    /**
     * 构建示例Po
     * cmd转po
     * @param testCmd 示例cmd
     * @return {@link TestPo}
     */
    public static TestPo buildTestPo( TestCmd testCmd ){
        TestPo testPo = new TestPo();
        testPo.setName(testCmd.getName());
        testPo.setAge(testCmd.getAge());
        testPo.setCode(testCmd.getCode());
        testPo.setSex(testCmd.getSex());
        return testPo;
    }
}
