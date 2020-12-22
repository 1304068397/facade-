package com.seasky.dddtemplate.interfaces.controller.test;


import com.seasky.dddtemplate.dto.test.TestQueryQry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 示例Q线tc工厂
 *
 * @author XueYawei
 * @date 2020/12/08
 */
public class TestQueryTcFactory {

    public static Stream<TestQueryTc> getTCQryStream(){
        List<TestQueryTc> testQueryTcs = new ArrayList<>();
        testQueryTcs.add(buildCase01());
        testQueryTcs.add(buildCase02());
        return testQueryTcs.stream();
    }
    private static TestQueryTc buildCase01() {
        TestQueryTc findStudentByConditionTc = new TestQueryTc("有条件");

        TestQueryQry studentQry = new TestQueryQry();
        studentQry.setName("阿萨德");
        findStudentByConditionTc.setQryParam(studentQry);
        //赋值期望返回条数
        findStudentByConditionTc.setExpectCount(1);
        return findStudentByConditionTc;
    }

    private static TestQueryTc buildCase02() {
        TestQueryTc findStudentByConditionTc = new TestQueryTc("空条件");

        TestQueryQry studentQry = new TestQueryQry();
        findStudentByConditionTc.setQryParam(studentQry);
        findStudentByConditionTc.setExpectCount(3);
        return findStudentByConditionTc;
    }


}
