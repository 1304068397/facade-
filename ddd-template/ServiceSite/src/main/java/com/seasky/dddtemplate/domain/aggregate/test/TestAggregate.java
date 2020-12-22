package com.seasky.dddtemplate.domain.aggregate.test;


import com.seasky.core.ddd.base.BaseAggregate;
import lombok.*;

/**
 * 示例聚合根
 *
 * @author XueYawei
 * @date 2020/12/07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TestAggregate extends BaseAggregate {

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

    /**
     * 状态
     */
    private String status;

    @Override
    protected String iniDescribeName() {
        return "示例";
    }

    public TestAggregate updata(TestAggregate aggregate) {
        // 进行校验 例如年龄大于0 小于 150
        // name code中不能有特殊字符等
        this.name = aggregate.name;
        this.code = aggregate.code;
        this.sex = aggregate.sex;
        this.age = aggregate.age;
        this.id = aggregate.id;
        return this;
    }

    public TestAggregate submit(String status) {
        this.status = status;
        return this;
    }

    public String BuildSubmitMessage() {
        return "";
    }
}
