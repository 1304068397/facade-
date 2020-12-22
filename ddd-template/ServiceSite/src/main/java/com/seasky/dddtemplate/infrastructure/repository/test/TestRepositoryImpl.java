package com.seasky.dddtemplate.infrastructure.repository.test;


import com.seasky.core.common.Error;
import com.seasky.core.common.ResponseCode;
import com.seasky.core.ddd.base.DomainKeysMap;
import com.seasky.core.exception.DataAccessException;
import com.seasky.dddtemplate.dto.test.TestQueryQry;
import com.seasky.dddtemplate.domain.aggregate.test.TestAggregate;
import com.seasky.dddtemplate.domain.aggregate.test.TestRepository;
import com.seasky.dddtemplate.infrastructure.dataobject.po.TestPo;
import com.seasky.dddtemplate.infrastructure.db.mapper.table.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 示例impl
 *
 * @author XueYawei
 * @date 2020/12/07
 */
@Repository
public class TestRepositoryImpl implements TestRepository {

    @Autowired
    TestMapper testMapper;

    /**
     * 保存示例
     *
     * @param testAggregate 示例聚合根
     * @return int
     */
    @Override
    public int saveTest(TestAggregate testAggregate) {
        //聚合转po
        TestPo testPo = TestConvert.TestAggregateToTestPo(testAggregate);
        //验证及特殊处理操作 代码 略
        TestQueryQry testQry = new TestQueryQry();
        testQry.setCode(testPo.getCode());
        if(testMapper.selectUserList(testQry).size() != 0){
            throw new DataAccessException(new Error(ResponseCode.SERVER_INTERNAL_EXCEPTION,null,"编号已存在",""));
        }

        return testMapper.insert(testPo);
    }

    @Override
    public Long save(TestAggregate aggregate) {
        return null;
    }

    @Override
    public void remove(TestAggregate aggregate) {

    }

    @Override
    public TestAggregate findByDomainKey(DomainKeysMap domainKeysMap) {
        return null;
    }

    @Override
    public Boolean isExistsByDomainKey(DomainKeysMap domainKeysMap) {
        return null;
    }

    @Override
    public TestAggregate findByPersistentId(Long aLong) {
        return null;
    }
}
