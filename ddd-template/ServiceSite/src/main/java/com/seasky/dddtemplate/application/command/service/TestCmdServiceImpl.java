package com.seasky.dddtemplate.application.command.service;

import com.seasky.dddtemplate.application.command.api.TestCmdService;
import com.seasky.dddtemplate.application.command.factory.TestFactory;
import com.seasky.dddtemplate.domain.aggregate.test.TestAggregate;
import com.seasky.dddtemplate.domain.aggregate.test.TestRepository;
import com.seasky.dddtemplate.domain.api.TestDomainService;
import com.seasky.dddtemplate.domain.event.DeleteTestEvent;
import com.seasky.dddtemplate.domain.event.SendMessageEvent;
import com.seasky.dddtemplate.dto.test.TestCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCmdServiceImpl implements TestCmdService {
    @Autowired
    private TestDomainService testDomainService;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private SendMessageEvent sendMessageEvent;

    @Autowired
    private DeleteTestEvent  deleteTestEvent;
    /**
     * 保存
     *
     * @param testCmd
     * @return {@link Long}
     */
    @Override
    public Long SaveTest(TestCmd testCmd) {
        TestAggregate testAggregate = TestFactory.buildTestAggregate(testCmd);
        return this.save(testAggregate);
    }

    /**
     * 提交
     *
     * @param testCmd
     * @return {@link int}
     */
    @Override
    public Long SubmitTest(TestCmd testCmd) {
        TestAggregate testAggregate = TestFactory.buildTestAggregate(testCmd);
        this.submit(testAggregate);
        return 0l;
    }

    /**
     * 保存并提交
     *
     * @param testCmd
     * @return {@link int}
     */
    @Override
    public Long SavaAndSubmitTest(TestCmd testCmd) {
        TestAggregate testAggregate = TestFactory.buildTestAggregate(testCmd);
        Long result = this.save(testAggregate);
        this.submit(testAggregate);
        return result;
    }

    /**
     * 删除
     *
     * @param testCmd
     * @return {@link int}
     */
    @Override
    public void Delete(TestCmd testCmd) {
        TestAggregate testAggregate = TestFactory.buildTestAggregate(testCmd);
        deleteTestEvent.DeleteVerify(testAggregate.getCode());
        testRepository.remove(testAggregate);
    }

    /**
     * 保存共用方法
     *
     * @param testAggregate
     * @return {@link Long}
     */
    private Long save(TestAggregate testAggregate){
        TestAggregate aggregate = testRepository.findByPersistentId(testAggregate.getId());
        aggregate = aggregate.updata(testAggregate);
        return testRepository.save(aggregate);
    }

    /**
     * 提交共用方法
     *
     * @param testAggregate
     * @return {@link TestAggregate}
     */
    private TestAggregate submit(TestAggregate testAggregate) {
        testAggregate = testDomainService.submitTest(testAggregate);
        String  message = testAggregate.BuildSubmitMessage();
        // 此处调用flowRepository 根据 业务单号获取审核用户列表
        sendMessageEvent.send(message,"获取到的用户列表");
        return testAggregate;
    }
}
