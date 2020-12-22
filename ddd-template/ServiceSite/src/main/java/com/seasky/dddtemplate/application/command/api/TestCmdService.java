package com.seasky.dddtemplate.application.command.api;

import com.seasky.dddtemplate.dto.test.TestCmd;

public interface TestCmdService {
    /**
     * 保存示例
     *
     * @param testCmd 测试cmd
     * @return int
     */
    Long SaveTest(TestCmd testCmd);

    /**
     * 提交示例
     *
     * @param testCmd 测试cmd
     * @return int
     */
    Long SubmitTest(TestCmd testCmd);

    /**
     * 保存并提交示例
     *
     * @param testCmd 测试cmd
     * @return int
     */
    Long SavaAndSubmitTest(TestCmd testCmd);

    void Delete(TestCmd testCmd);
}
