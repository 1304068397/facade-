package com.seasky.dddtemplate.infrastructure.repository.test;


import com.seasky.core.ddd.utils.MapperUtils;
import com.seasky.dddtemplate.domain.aggregate.test.TestAggregate;
import com.seasky.dddtemplate.infrastructure.dataobject.po.TestPo;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例转换
 *
 * @author XueYawei
 * @date 2020/12/08
 */
public class TestConvert {


    /**
     * 示例聚合根转为示例Po类
     *
     * @param testAggregate 示例聚合根
     * @return {@link TestPo}
     */
    public static TestPo TestAggregateToTestPo(TestAggregate testAggregate){
        //转换对应键值map
        Map<String, String> map = new HashMap<>(3);
        TestPo testPo = MapperUtils.INSTANCE.map(TestPo.class, testAggregate);

        return testPo;
    }


}
