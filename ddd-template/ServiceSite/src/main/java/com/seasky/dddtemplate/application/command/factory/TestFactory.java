package com.seasky.dddtemplate.application.command.factory;


import com.seasky.core.ddd.utils.MapperUtils;
import com.seasky.dddtemplate.domain.aggregate.test.TestAggregate;
import com.seasky.dddtemplate.dto.test.TestCmd;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例工厂类
 *
 * @author XueYawei
 * @date 2020/12/07
 */
public class TestFactory {


    /**
     * 构建示例聚合根
     *
     * @param testCmd 测试cmd
     * @return {@link TestAggregate}
     */
    public static TestAggregate buildTestAggregate(TestCmd testCmd) {
        //转换对应键值map
        Map<String, String> map = new HashMap<>(3);
        TestAggregate testAggregate = MapperUtils.INSTANCE.map(TestAggregate.class,testCmd);
        return testAggregate;
    }
}
