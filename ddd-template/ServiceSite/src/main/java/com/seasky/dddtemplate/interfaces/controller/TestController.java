package com.seasky.dddtemplate.interfaces.controller;


import com.seasky.core.common.ResponseCode;
import com.seasky.core.common.Result;
import com.seasky.dddtemplate.api.ITestController;
import com.seasky.dddtemplate.application.command.api.TestCmdService;
import com.seasky.dddtemplate.application.query.TestQueryService;
import com.seasky.dddtemplate.dto.test.TestCmd;
import com.seasky.dddtemplate.dto.test.TestQueryOut;
import com.seasky.dddtemplate.dto.test.TestQueryQry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import static com.seasky.core.common.Response.ok;

/**
 * 示例API
 *
 * @author XueYawei
 * @date 2020/12/07
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController extends BaseController implements ITestController {

    @Autowired
    private TestCmdService testApplicationCmdService;
    @Autowired
    private TestQueryService testQueryService;

    @Override
    public Object testQResEntity(@RequestBody TestQueryQry testQry){
        try {
            log.info("进入testQResEntity方法"+new Date()+",准备睡眠3s");
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("睡眠3s，已结束，准备调用方法-->"+new Date());
        return testQueryService.queryTestList(testQry);
    }

    /**
     * 查询示例
     *
     * @param testQry
     * @return {@link Result<TestQueryOut>}
     */
    @Override
    public Result<TestQueryOut> testQ(@RequestBody TestQueryQry testQry){
        return ok(ResponseCode.SUCCESS, testQueryService.queryTestList(testQry));
    }

    /**
     * 导出
     * 与testQ同样获取数据,但转换成不同数据格式返回
     *
     * @param testQry
     * @return {@link ResponseEntity<byte[]>}
     */
    @Override
    public ResponseEntity<byte[]> testExcelExport(@RequestBody TestQueryQry testQry) throws UnsupportedEncodingException {
        List<TestQueryOut> list = testQueryService.queryTestList(testQry);

        byte[] excelbyte = null; // 此处调用excel工具类转成excel
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Length", "0");
        header.add("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode("xxxnanme", "UTF-8"));
        return new ResponseEntity<>(excelbyte, header, HttpStatus.OK);
    }

    /**
     * 保存草稿
     *
     * @param testCmd
     * @return {@link Result<Long>}
     */
    @Override
    public Result<Long> testSave(TestCmd testCmd) {
        return ok(ResponseCode.SUCCESS, testApplicationCmdService.SaveTest(testCmd));
    }

    /**
     * 提交
     *
     * @param testCmd
     * @return {@link Result<Long>}
     */
    @Override
    public Result<Long> testSubmit(TestCmd testCmd) {
        return ok(ResponseCode.SUCCESS, testApplicationCmdService.SubmitTest(testCmd));
    }

    /**
     * 保存并提交
     *
     * @param testCmd
     * @return {@link Result<Long>}
     */
    @Override
    public Result<Long> testSaveAndSubmit(TestCmd testCmd) {
        return  ok(ResponseCode.SUCCESS, testApplicationCmdService.SavaAndSubmitTest(testCmd));
    }
}
