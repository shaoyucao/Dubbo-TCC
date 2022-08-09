package com.syc.springboot.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.syc.springboot.dubbo.transaction.TransactionConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubboConfiguration
public class ConsumerApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(ConsumerApplication.class, args);

        TransactionConsumer transactionConsumer = (TransactionConsumer)context.getBean("transactionConsumer");
        transactionConsumer.sendMessage("msg");
    }

}
