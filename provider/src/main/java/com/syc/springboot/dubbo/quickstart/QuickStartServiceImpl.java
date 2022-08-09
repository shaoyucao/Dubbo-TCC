package com.syc.springboot.dubbo.quickstart;

import com.alibaba.dubbo.config.annotation.Service;
import com.syc.springboot.dubbo.ServiceApi;
import org.springframework.stereotype.Component;

//@Component
//@Service(interfaceClass = ServiceApi.class)
public class QuickStartServiceImpl implements ServiceApi {

    @Override
    public String sendMessage(String message) {
        return "quickstart-provider-message=" + message;
    }
}
