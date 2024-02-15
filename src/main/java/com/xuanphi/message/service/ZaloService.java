package com.xuanphi.message.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageService {
    public ZaloService(){
        System.out.println("Constructor cua lop: " + getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Sending zalo message...";
    }
}
