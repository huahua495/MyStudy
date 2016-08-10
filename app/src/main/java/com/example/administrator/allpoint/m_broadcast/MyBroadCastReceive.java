package com.example.administrator.allpoint.m_broadcast;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.example.administrator.allpoint.R;
import com.example.administrator.allpoint.utils.Tu;

/**
 * Created by Administrator on 2016/8/8.
 * AllPoint
 * 说明：
 */
public class MyBroadCastReceive extends BroadcastReceiver {
    private static final int MY_RECEIVE = 1;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        /**
         * 首先我们监听一下网路的变化,我们可以针对网络的具体变化，做出相应的提示
         */
        Tu.show(context, "netwok is changed!");

        //step1 获取状态通知栏管理：
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        //step2 实例化通知栏构造器NotificationCompat.Builder

        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("我是标题")
                .setContentText("我是内容")
//                .setContentIntent()//设置通知栏点击意图
//                .setNumber(number) //设置通知集合的数量
                .setTicker("您有通知消息，请注意查收！")//通知首次出现在通知栏，带上升动画效果的
                .setPriority(Notification.PRIORITY_DEFAULT)//设置该通知优先级
                        //  .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setDefaults(Notification.DEFAULT_VIBRATE)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
                .setSmallIcon(R.mipmap.ic_launcher);//设置通知小ICON


//        Notification notification = new Notification(R.mipmap.ic_launcher, "一条通知消息", System.currentTimeMillis());

       manager.notify(1,builder.build());
    }
}
