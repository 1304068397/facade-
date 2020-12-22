package com.seasky.dddtemplate.dto.test;


import com.seasky.core.ddd.base.BaseDto;
import lombok.Data;

/**
 * 示例cmd
 * 此类为C线接口传入的参数类  在DDD结构中属于application层的 DTO类
 * 需要继承 BaseDto
 * @author XueYawei
 * @date 2020/12/07
 */
@Data
public class TestCmd extends BaseDto {
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
}
