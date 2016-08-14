package com.example.administrator.allpoint.m_data_storage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.allpoint.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by huahua on 2016/8/13.
 * Sqlite 数据库存储
 */
public class SqliteActivity extends AppCompatActivity {

    @InjectView(R.id.btn_create_db)
    Button btnCreateDb;

    MySqilite sqilite;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        initView();

    }
    private void initView() {
        ButterKnife.inject(this);

        sqilite=new MySqilite(SqliteActivity.this,"BookStore.db",null,1);
        btnCreateDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqilite.getWritableDatabase();
            }
        });
    }
}
