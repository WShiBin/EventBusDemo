package com.ruanke.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

/**
 * *********************************************************
 * <p>
 * PROJECT: EventBusDemo
 * DESCRIPTION: //todo
 * DATE: 2017/03/11:40 PM
 * AUTHOR: shibin1990
 * Email: shib90@qq.com
 * <p>
 * *********************************************************
 */

public class PublisherActivity extends AppCompatActivity {

    private static final String TAG = "PublisherActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher);
        findViewById(R.id.btn_send_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: 推送消息");
                EventBus.getDefault().post(new LoginEvent("Hello EventBus"));
            }
        });
        findViewById(R.id.btn_send_sticky_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: 推送黏性消息");
                EventBus.getDefault().postSticky(new LoginEvent("Hello EventBus"));
            }
        });
        findViewById(R.id.btn_start_sticky_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PublisherActivity.this, SubscriberStickyEventActivity.class));
            }
        });
    }
}
