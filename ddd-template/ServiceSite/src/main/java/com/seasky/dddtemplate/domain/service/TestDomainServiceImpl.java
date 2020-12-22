package com.seasky.dddtemplate.domain.service;


import com.seasky.dddtemplate.domain.aggregate.test.TestAggregate;
import com.seasky.dddtemplate.domain.aggregate.test.TestRepository;
import com.seasky.dddtemplate.domain.api.TestDomainService;
import com.seasky.dddtemplate.domain.event.DeleteTestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 示例进口服务
 *
 * @author XueYawei
 * @date 2020/12/07
 */
@Service
public class TestDomainServiceImpl implements TestDomainService {

    @Autowired
    TestRepository testRepository;


    /**
     * 业务操作
     */
    @Override
    public TestAggregate submitTest(TestAggregate testAggregate) {
        // 业务代码
        TestAggregate aggregate = testRepository.findByPersistentId(testAggregate.getId());

        // 此处调用repository获取数据做校验,比如工号不能重复
//
//        FlowAggregate flowAggregate = flowRepository.findByTestCode(testAggregate.getCode());
//        flowAggregate.submit(testAggregate.getCode());
//
//        if(aggregate.getAge()>50){
//            flowAggregate = flowRepository.submitA(flowAggregate);
//        } else {
//            flowAggregate = flowRepository.submitB(flowAggregate);
//        }
//
//        aggregate.submit(flowAggregate.getStatus());
         testRepository.save(testAggregate);
        return aggregate;
    }


    @EventListener
    @Order(1)
    public void deleteTestVerify(DeleteTestEvent event) {
        // 进行删除test的校验
        System.out.println("Test收到删除事件，参数:" + event.getSource());//获取参数
    }
}
