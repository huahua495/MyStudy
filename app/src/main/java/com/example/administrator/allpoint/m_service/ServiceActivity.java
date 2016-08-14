package com.example.administrator.allpoint.m_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.allpoint.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/7/29.
 * AllPoint
 * 说明：service 绑定的activity
 */
public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.start)
    Button start;
    @InjectView(R.id.bind)
    Button bind;
    @InjectView(R.id.stop)
    Button stop;
    @InjectView(R.id.unbind)
    Button unbind;

    private MyService.MyBinder binder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder = (MyService.MyBinder) iBinder;
            binder.downLoad();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        initView();
    }

    private void initView() {
        ButterKnife.inject(this);

        start.setOnClickListener(this);
        bind.setOnClickListener(this);
        stop.setOnClickListener(this);
        unbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.bind:
                Intent intent = new Intent(this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.stop:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.unbind:
                unbindService(connection);
                break;
        }
    }
}
