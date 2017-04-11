package com.ruanke.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapp.MyEventBusIndex;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * *********************************************************
 * <p>
 * PROJECT: EventBusDemo
 * DESCRIPTION: //todo
 * DATE: 2017/03/11:38 PM
 * AUTHOR: shibin1990
 * Email: shib90@qq.com
 * <p>
 * *********************************************************
 */

public class Subscriber1Activity extends AppCompatActivity {

    private static final String TAG = "Subscriber1Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriber1);

        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Subscriber1Activity.this, PublisherActivity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginEvent event) {
        Log.i(TAG, "onMessageEvent: 我是订阅者1号,接收到消息 ");
//        Log.i(TAG, "onMessageEvent: " + event.message + TAG);
        Toast.makeText(this, event.message + TAG, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
        if (!EventBus.getDefault().isRegistered(this)) {
            Log.i(TAG, "onMessageEvent: register start " + System.currentTimeMillis());
            EventBus.getDefault().register(this);
            Log.i(TAG, "onMessageEvent: register end " + System.currentTimeMillis());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
