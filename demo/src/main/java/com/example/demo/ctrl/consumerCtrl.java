package com.example.demo.ctrl;

import com.seasky.dddtemplate.api.ITestController;
import com.seasky.dddtemplate.dto.test.TestQueryQry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PackageName:com.example.demo.ctrl
 * @ClassName:consumerCtrl
 * @Description:
 * @Author:王宗保
 * @Version V1.0.0
 * @Date:2020/12/22 21:05
 */
@Api("consumerCtrl")
@RestController
@Slf4j
public class consumerCtrl {

    @Resource
    ITestController iTestController;

    @ApiOperation("testQResEntity")
    @PostMapping("consumerTestQResEntity")
    public Object testQResEntity(){
        return iTestController.testQResEntity(new TestQueryQry());
    }

    /**
     * testQ接口返回的类型不可接收
     * Error while extracting response for type
     * [com.seasky.core.common.Result<com.seasky.dddtemplate.dto.test.TestQueryOut>]
     * and content type [application/json;charset=UTF-8];
     *
     * 结论： 不是每一个controller都要去写facade，只有被调用的外部接口才需要去写facade，返回类型必须为（可接收的）对象
     * @return
     */
    @ApiOperation("testQ")
    @PostMapping("testQ")
    public Object testQ(){
        return iTestController.testQ(new TestQueryQry());
    }
}
