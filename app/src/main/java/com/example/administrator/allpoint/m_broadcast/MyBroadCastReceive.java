package com.example.administrator.allpoint.m_broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.administrator.allpoint.R;

/**
 * Created by Administrator on 2016/8/8.
 * AllPoint
 * 说明：
 */
public class MyBroadCastReceive extends BroadcastReceiver {
    private static final int MY_RECEIVE = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.mipmap.ic_launcher, "0808，我是01！", System.currentTimeMillis());
        manager.notify(MY_RECEIVE, notification);
    }
}
