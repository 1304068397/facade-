package com.seasky.dddtemplate.interfaces.controller.test;

import com.seasky.core.ddd.test.PoAssertions;
import com.seasky.dddtemplate.application.command.api.TestCmdService;
import com.seasky.dddtemplate.application.query.TestQueryService;
import com.seasky.dddtemplate.dto.test.TestQueryOut;
import com.seasky.dddtemplate.infrastructure.db.mapper.table.TestMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class TestControllerTest {

    @Autowired
    private TestCmdService testCmdService;
    @Autowired
    private TestQueryService testQueryService;

    @Autowired
    TestMapper testMapper;

    @ParameterizedTest
    @MethodSource("getTCStream")
    void testC(TestCmdTc testCase) {
        if(testCase.getIsPositiveCase()){//是否为正常入参对象
            testCmdService.SaveTest(testCase.getCmdParam());
        }else {//异常入参对象执行
            assertThrows(testCase.getExpectExceptionType().getClass(),
                    ()->testCmdService.SaveTest(testCase.getCmdParam()),testCase.getFlag());
        }

        //验证 以上接口是否执行成功
        System.out.println(testCase.getFlag());
        testCase.getExceptTestPoList().forEach((key,value)->{
            PoAssertions.assertRecordCount(key,testMapper,value,testCase.getFlag());
        });

    }
    static Stream<TestCmdTc> getTCStream(){
        return TestCmdFactory.getTCStream();
    }


    @ParameterizedTest
    @MethodSource("getTCQryStream")
    void testQ(TestQueryTc testCase) {
        List<TestQueryOut> outList = testQueryService.queryTestList(testCase.getQryParam());
        System.out.println("----返回输出-------------========>>>"+outList.size()+"========="+outList);
        //验证返回条数与期望返回条数是否一致
        System.out.println(testCase.getFlag());
        assertEquals(outList.size(),testCase.getExpectCount());
    }
    static Stream<TestQueryTc> getTCQryStream(){return TestQueryTcFactory.getTCQryStream();}
}