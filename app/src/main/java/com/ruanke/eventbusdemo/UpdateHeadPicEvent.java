package com.ruanke.eventbusdemo;

/**
 * *********************************************************
 * <pre>
 * PROJECT: EventBusDemo
 * INTRODUCATION: //todo
 * DESCRIPTION: //todo
 * DATE: 2017/04/4:45 PM
 * AUTHOR: shibin1990
 * Email: shib90@qq.com
 * </pre>
 * *********************************************************
 */

public class UpdateHeadPicEvent {

    private String mUrl;

    public UpdateHeadPicEvent(String url) {
        this.mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
