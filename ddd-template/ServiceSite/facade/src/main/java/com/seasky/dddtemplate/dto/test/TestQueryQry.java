package com.seasky.dddtemplate.dto.test;

import com.seasky.core.ddd.base.BaseDto;
import lombok.Data;

/**
 * 测试qry
 *
 * @author XueYawei
 * @date 2020/12/07
 */
@Data
public class TestQueryQry extends BaseDto {

    /**
     * 名字
     */
    private String name;
    /**
     * 编号
     */
    private String code;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private Integer age;


    private Integer pageIndex;

    private Integer pageSize;
}
