package com.seasky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/***
 * @author bandi
 * */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {
        "com.seasky.some-api"
        ,"com.seasky.other-api"
})
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
