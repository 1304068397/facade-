package com.seasky.dddtemplate.infrastructure.reader.test;


import com.seasky.core.ddd.utils.MapperUtils;
import com.seasky.dddtemplate.dto.test.TestQueryOut;
import com.seasky.dddtemplate.infrastructure.dataobject.po.TestPo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 示例Q线转换
 *
 * @author XueYawei
 * @date 2020/12/08
 */
public class TestQueryConvert {


    /**
     * Po类转为Out类
     *
     * @param testPo 示例Po类
     * @return {@link TestQueryOut}
     */
    public static TestQueryOut poToOut(TestPo testPo){
        //转换对应键值map
        Map<String, String> map = new HashMap<>(3);
        TestQueryOut testOut = MapperUtils.INSTANCE.map(TestQueryOut.class,testPo);
        return testOut;
    }


    /**
     * 列表po转为列表Out类
     *
     * @param listPo 列表Po类
     * @return {@link List< TestQueryOut >}
     */
    public static List<TestQueryOut> listPOToListOut(List<TestPo> listPo){
        //转换对应键值map
        Map<String, String> map = new HashMap<>(3);
        List<TestQueryOut> testOuts = MapperUtils.INSTANCE.mapAsList(TestQueryOut.class,listPo);
        return testOuts;
    }
}
