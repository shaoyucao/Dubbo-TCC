package com.syc.springboot.dubbo;

import org.mengyun.tcctransaction.api.Compensable;

public interface ServiceApi {

    @Compensable
    String sendMessage(String message);

}
