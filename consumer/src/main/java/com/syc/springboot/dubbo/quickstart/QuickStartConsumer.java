package com.syc.springboot.dubbo.quickstart;

import com.alibaba.dubbo.config.annotation.Reference;
import com.syc.springboot.dubbo.ServiceApi;
import org.springframework.stereotype.Component;

//@Component
public class QuickStartConsumer {

    @Reference(interfaceClass = ServiceApi.class)
    private ServiceApi serviceApi;

    public void sendMessage(String message) {

        System.out.println(serviceApi.sendMessage(message));
    }
}
