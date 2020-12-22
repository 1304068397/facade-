package com.seasky.dddtemplate.infrastructure.reader.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seasky.core.base.AbstractService;
import com.seasky.dddtemplate.application.query.TestQueryService;
import com.seasky.dddtemplate.dto.test.TestQueryOut;
import com.seasky.dddtemplate.dto.test.TestQueryQry;
import com.seasky.dddtemplate.infrastructure.dataobject.po.TestPo;
import com.seasky.dddtemplate.infrastructure.db.mapper.table.TestMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 示例查询服务impl
 *
 * @author XueYawei
 * @date 2020/12/08
 */
@Repository
public class TestQueryServiceImpl  extends AbstractService<TestPo,TestMapper> implements TestQueryService {


    @Override
    public List<TestQueryOut> queryTestList(TestQueryQry testQry) {
        //验证代码略
        QueryWrapper<TestPo> queryWapper = new QueryWrapper<>();
        if (testQry.getName()!= null && !"".equals(testQry.getName())){
            queryWapper.eq("name",testQry.getName());
        }
        List<TestPo> testPos = list(TestPo.builder().name(testQry.getName()).build());
        List<TestQueryOut> testOuts = TestQueryConvert.listPOToListOut(testPos);
        return testOuts;
    }
}
