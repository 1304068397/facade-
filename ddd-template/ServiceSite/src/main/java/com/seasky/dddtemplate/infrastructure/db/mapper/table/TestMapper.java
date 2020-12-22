package com.seasky.dddtemplate.infrastructure.db.mapper.table;

import com.seasky.core.base.BaseMapper;
import com.seasky.dddtemplate.dto.test.TestQueryQry;
import com.seasky.dddtemplate.infrastructure.dataobject.po.TestPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 示例映射器
 *
 * @author XueYawei
 * @date 2020/12/08
 */
@Mapper
public interface TestMapper extends BaseMapper<TestPo> {

    /**
     * 选择用户列表
     *
     * @param testQry 示例qry
     * @return {@link List<TestPo>}
     */
    List<TestPo> selectUserList(@Param("pm") TestQueryQry testQry);


}
