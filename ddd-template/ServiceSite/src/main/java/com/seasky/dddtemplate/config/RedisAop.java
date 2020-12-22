package com.seasky.dddtemplate.config;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.seasky.core.cache.CacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.Map;

@Aspect
@Slf4j
@Component
public class RedisAop {

    /**
     * @Title: pointMapperUpdate
     * @Description: 定义切点为Mapper
     * @return void
     **/
    @Pointcut("execution(* com.seasky.*.infrastructure.mapper.*.update*(..)))")
    public void pointMapperUpdate() {
    }

    @Around("pointMapperUpdate()")
    public Object doAroundUpdateMapper(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info( "doAroundUpdateMapper开始----->"+new Date());
        //参数值
        Object[] method_args = joinPoint.getArgs();
        Map map = JSONObject.parseObject(JSONObject.toJSONString(method_args[0]), Map.class);
        String name = method_args[0].getClass().getName();
        String substring = name.substring(name.lastIndexOf(".") + 1);
        deleteCacheByPoNameAndId(substring,map.get("id"));
        return joinPoint.proceed();
    }

    @Pointcut("execution(* com.seasky.*.infrastructure.mapper.*.delete*(..)))")
    public void pointMapperDelete(){
    }

    @Around("pointMapperDelete()")
    public Object doAroundDeleteMapper(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info( "doAroundDeleteMapper开始----->"+new Date());
        Mapper mapper = (Mapper) joinPoint.getTarget();
        Class poClazz = Class.class.cast(ParameterizedType.class.cast(Class.class.cast(mapper.getClass().getGenericInterfaces()[0]).getGenericInterfaces()[0]).getActualTypeArguments()[0]);
        String name = poClazz.getName();
        //获得Po名称
        String substring = name.substring(name.lastIndexOf(".") + 1);
        //参数值
        Object[] method_args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        sb.append( "缓存已删除----->");
        for (Object id:method_args) {
            deleteCacheByPoNameAndId(substring,id);
            sb.append(id+";");
        }
        log.info(sb.toString());
        return joinPoint.proceed();
    }

    public static void deleteCacheByPoNameAndId(String poName, Object id){
        String cacheKey = "basedata:cache:entity:"+poName+":"+id;
        CacheUtil.getCacheCommand().del(cacheKey);
    }
}
