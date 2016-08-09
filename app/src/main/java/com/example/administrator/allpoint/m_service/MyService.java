package com.example.administrator.allpoint.m_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.administrator.allpoint.utils.L;

/**
 * Created by Administrator on 2016/7/29.
 * AllPoint
 * 说明：Service
 *
 *  注：service运行在主线程，不能进行耗时操作，否则会出现ANR，
 *      如果需要进行耗时操作，可以开启线程处理
 */
public class MyService extends Service {

    private MyBinder binder=new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        L.e("Myservice is oncreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        L.e("Myservice is onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        L.e("Myservice is onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean onUnbind(Intent intent) {
        L.e("Myservice is onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.e("Myservice is onDestroy");
    }

    class  MyBinder extends Binder{
        public void downLoad(){
            L.i("downLoad() is start");
        }
    }
}
