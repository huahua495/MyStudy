package com.example.administrator.allpoint.m_data_storage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.allpoint.R;
import com.example.administrator.allpoint.utils.Tu;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by huahua on 2016/8/13.
 * 各种数据存储
 */
public class DataStorageAct extends AppCompatActivity implements View.OnClickListener{
    @InjectView(R.id.btn_file)
    Button btnFile;
    @InjectView(R.id.btn_sqlite)
    Button btnSqlite;
    @InjectView(R.id.btn_sharedpre)
    Button btnSharedpre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        initView();

    }

    private void initView() {
        ButterKnife.inject(this);

        btnFile.setOnClickListener(this);
        btnSqlite.setOnClickListener(this);
        btnSharedpre.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_file:
                startActivity(new Intent(this,FileStorage.class));
                break;
            case R.id.btn_sqlite:
                startActivity(new Intent(this,SqliteActivity.class));
                break;
            case R.id.btn_sharedpre:
                Tu.show(this,"这个就不写了！");
                break;
        }
    }
}
