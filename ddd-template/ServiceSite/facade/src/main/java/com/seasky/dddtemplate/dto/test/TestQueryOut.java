package com.seasky.dddtemplate.dto.test;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.seasky.core.ddd.base.BaseDto;
import com.seasky.core.enums.Available;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试Out类
 *
 * @author XueYawei
 * @date 2020/12/07
 * JsonInclude(JsonInclude.Include.ALWAYS)  ---> 任何情况下都序列化该字段 ,数据库返回值为空时,仍然返回该字段给前端 且该字段为 null
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class TestQueryOut extends BaseDto implements Serializable {
    /**
     * 主键
     */
    private Long id;
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


    protected Date createDate;

    protected Long creator;

    protected Long updator;

    protected Date updateDate;

    protected Available available;

    protected String remark;

    protected Date versionDate;

}
