package com.example.administrator.allpoint.m_broadcast;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.administrator.allpoint.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/9.
 * AllPoint
 * 说明： 模仿发送广播
 * <p/>
 * 基本上系统来电，短信，网络状态变化的都会发送系统的广播，
 */
public class BroadCastActivity extends AppCompatActivity {

    @InjectView(R.id.btn_send_broadcase)
    Button btnSendBroadcase;

    private MyBroadCastReceive receive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcase);
        initView();
        registerBroad();
    }

    /***
     * 注册广播
     */
    private void registerBroad() {
        IntentFilter filter=new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receive=new MyBroadCastReceive();
     registerReceiver(receive,filter);
    }

    private void initView() {
        ButterKnife.inject(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receive);
    }
}
