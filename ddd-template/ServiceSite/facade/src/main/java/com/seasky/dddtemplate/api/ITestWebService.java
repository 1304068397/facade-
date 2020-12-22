package com.seasky.dddtemplate.api;

import com.seasky.core.common.Result;
import com.seasky.dddtemplate.dto.test.TestQueryOut;
import com.seasky.dddtemplate.dto.test.TestQueryQry;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "TestService", targetNamespace = "http://www.seaskysh.com")
public interface ITestWebService {
    @WebMethod
    Result<TestQueryOut> testQ(@WebParam TestQueryQry testQry);
}

