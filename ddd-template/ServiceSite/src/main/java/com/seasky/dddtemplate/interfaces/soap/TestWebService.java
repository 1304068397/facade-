package com.seasky.dddtemplate.interfaces.soap;

import com.seasky.core.common.ResponseCode;
import com.seasky.core.common.Result;
import com.seasky.dddtemplate.api.ITestWebService;
import com.seasky.dddtemplate.application.query.TestQueryService;
import com.seasky.dddtemplate.dto.test.TestQueryOut;
import com.seasky.dddtemplate.dto.test.TestQueryQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import static com.seasky.core.common.Response.ok;

@Component
@WebService(name = "TestService", targetNamespace = "http://www.seaskysh.com",
        endpointInterface = "com.seasky.dddtemplate.api.ITestWebService")
public class TestWebService implements ITestWebService {
    @Autowired
    private TestQueryService testQueryService;

    @Override
    public Result<TestQueryOut> testQ(TestQueryQry testQry) {
        return ok(ResponseCode.SUCCESS, testQueryService.queryTestList(testQry));
    }
}
