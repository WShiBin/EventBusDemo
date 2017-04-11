package com.ruanke.eventbusdemo;

import android.app.usage.UsageEvents;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * *********************************************************
 * <pre>
 * PROJECT: EventBusDemo
 * INTRODUCATION: //todo
 * DESCRIPTION: //todo
 * DATE: 2017/04/3:30 PM
 * AUTHOR: shibin1990
 * Email: shib90@qq.com
 * </pre>
 * *********************************************************
 */

public class SubscriberStickyEventActivity extends AppCompatActivity {

    private static final String TAG = "SubscriberStickyEventAc";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriber_sticky_event);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Subscribe(sticky = true)
    public void onMessageEvent(LoginEvent event) {
        Log.i(TAG, "onMessageEvent: 我是黏性事件接收者 收到消息");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

