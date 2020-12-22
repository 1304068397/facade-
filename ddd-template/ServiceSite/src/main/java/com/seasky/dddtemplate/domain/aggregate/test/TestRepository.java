package com.seasky.dddtemplate.domain.aggregate.test;

import com.seasky.core.ddd.base.DddRepository;

/**
 * 示例存储库
 *
 * @author XueYawei
 * @date 2020/12/07
 */
public interface TestRepository extends DddRepository<TestAggregate> {
    /**
     * 保存示例
     *
     * @param testAggregate 示例聚合根
     * @return int
     */
    int saveTest(TestAggregate testAggregate);
}
