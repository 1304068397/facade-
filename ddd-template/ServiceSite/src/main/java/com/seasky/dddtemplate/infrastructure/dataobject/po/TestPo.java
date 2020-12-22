package com.seasky.dddtemplate.infrastructure.dataobject.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 示例Po类
 *
 * @author XueYawei
 * @date 2020/12/07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "tb_user",autoResultMap = true)
public class TestPo extends BasePO {
    @TableField("name")
    private String name;
    @TableField("code")
    private String code;
    @TableField("sex")
    private String sex;
    @TableField("age")
    private Integer age;



}
