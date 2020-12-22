package com.seasky.dddtemplate.application.query;


import com.seasky.core.base.BaseService;
import com.seasky.dddtemplate.dto.test.TestQueryOut;
import com.seasky.dddtemplate.dto.test.TestQueryQry;
import com.seasky.dddtemplate.infrastructure.dataobject.po.TestPo;

import java.util.List;

/**
 * 测试查询服务
 *
 * @author XueYawei
 * @date 2020/12/07
 */
public interface TestQueryService extends BaseService<TestPo> {


    /**
     * 查询测试
     *
     * @param testQry 测试qry
     * @return {@link TestQueryOut}
     */
    List<TestQueryOut> queryTestList(TestQueryQry testQry);
}
