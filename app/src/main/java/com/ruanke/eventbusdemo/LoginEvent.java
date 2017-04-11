package com.ruanke.eventbusdemo;

/**
 * *********************************************************
 * <p>
 * PROJECT: EventBusDemo
 * DESCRIPTION: //todo
 * DATE: 2017/03/11:42 PM
 * AUTHOR: shibin1990
 * Email: shib90@qq.com
 * <p>
 * *********************************************************
 */

public class LoginEvent {

    public final String message;

    public LoginEvent(String message) {
        this.message = message;
    }
}
