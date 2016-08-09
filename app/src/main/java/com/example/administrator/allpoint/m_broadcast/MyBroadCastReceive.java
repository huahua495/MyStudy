package com.example.administrator.allpoint.m_broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.administrator.allpoint.R;
import com.example.administrator.allpoint.utils.Tu;

/**
 * Created by Administrator on 2016/8/8.
 * AllPoint
 * 说明：
 */
public class MyBroadCastReceive extends BroadcastReceiver {
    private static final int MY_RECEIVE = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        /**
         * 首先我们监听一下网路的变化
         */
        Tu.show(context,"netwok is changed!");

    }
}
