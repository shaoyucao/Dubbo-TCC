package com.syc.springboot.dubbo.transaction;

import com.alibaba.dubbo.config.annotation.Reference;
import com.syc.springboot.dubbo.ServiceApi;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

    @Reference(interfaceClass = ServiceApi.class)
    private ServiceApi serviceApi;

    @Compensable(confirmMethod = "confirmSendMessage", cancelMethod = "cancelSendMessage", asyncConfirm = true)
    public void sendMessage(String message) {
        System.out.println("发送信息：this is consumer sendMessage try message = " + message);
        System.out.println(serviceApi.sendMessage(message));
    }

    public void confirmSendMessage(String message) {
        System.out.println("成功确认：this is consumer confirmSendMessage message = " + message);

    }

    public void cancelSendMessage(String message) {
        System.out.println("失败取消：this is consumer cancelSendMessage message = " + message);

    }
}
