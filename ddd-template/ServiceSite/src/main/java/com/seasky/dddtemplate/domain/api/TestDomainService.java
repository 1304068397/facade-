package com.seasky.dddtemplate.domain.api;

import com.seasky.dddtemplate.domain.aggregate.test.TestAggregate;

/**
 * 示例C线服务接口层
 *
 * @author XueYawei
 * @date 2020/12/07
 */
public interface TestDomainService {
    /**
     * 提交示例
     *
     * @param testAggregate 测试aggregate
     * @return int
     */
    TestAggregate submitTest(TestAggregate testAggregate);
}
