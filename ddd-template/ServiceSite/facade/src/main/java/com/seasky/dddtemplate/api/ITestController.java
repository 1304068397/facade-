package com.seasky.dddtemplate.api;

import com.seasky.core.common.Result;
import com.seasky.dddtemplate.dto.test.TestCmd;
import com.seasky.dddtemplate.dto.test.TestQueryOut;
import com.seasky.dddtemplate.dto.test.TestQueryQry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

@FeignClient("dddtemplate-provider")
@RequestMapping("test")
@Api("Test")
public interface ITestController {

    @ApiOperation("0.testQResEntity")
    @PostMapping(path = "/pc/v1/testQResEntity")
    Object testQResEntity(@RequestBody TestQueryQry testQry);

    @ApiOperation("1.testQ")
    @PostMapping(path = "/pc/v1/queryList")
    Result<TestQueryOut> testQ(@RequestBody TestQueryQry testQry);

    @ApiOperation("2.testExport")
    @PostMapping(path = "/pc/v1/export")
    ResponseEntity<byte[]> testExcelExport(@RequestBody TestQueryQry testQry) throws UnsupportedEncodingException;

    @ApiOperation("3.testSave")
    @PostMapping(path = "/pc/v1/save")
    Result<Long> testSave(@RequestBody TestCmd testCmd);

    @ApiOperation("4.testSubmit")
    @PostMapping(path = "/pc/v1/submit")
    Result<Long> testSubmit(@RequestBody TestCmd testCmd);

    @ApiOperation("5.testSaveAndSubmit")
    @PostMapping(path = "/pc/v1/saveandsubmit")
    Result<Long> testSaveAndSubmit(@RequestBody TestCmd testCmd);
}
