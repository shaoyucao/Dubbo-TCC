package com.syc.springboot.dubbo.transaction;

import com.alibaba.dubbo.config.annotation.Service;
import com.syc.springboot.dubbo.ServiceApi;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.context.MethodTransactionContextEditor;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = ServiceApi.class)
public class TransactionServiceImpl implements ServiceApi {

    @Override
    @Compensable(confirmMethod = "confirmSendMessage", cancelMethod = "cancelSendMessage", transactionContextEditor = MethodTransactionContextEditor.class)
    public String sendMessage(String message) {
        System.out.println("服务端接收到信息：this is sendMessage try message = " + message);
        if(message.equals("failTest")) {
            throw new NullPointerException();
        }
        return "服务端回调结果：quickstart-provider-message=" + message;
    }

    public String confirmSendMessage(String message) {
        System.out.println("成功确认：this is confirmSendMessage message = " + message);
        return "服务端回调结果：quickstart-provider-message=" + message;
    }

    public String cancelSendMessage(String message) {
        System.out.println("失败取消：this is cancelSendMessage message = " + message);
        return "服务端回调结果：quickstart-provider-message=" + message;
    }
}
