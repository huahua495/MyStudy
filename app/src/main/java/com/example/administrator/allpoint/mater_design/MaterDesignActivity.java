package com.example.administrator.allpoint.mater_design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.allpoint.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/1.
 * AllPoint
 * 说明：
 */
public class MaterDesignActivity extends AppCompatActivity implements View.OnClickListener{

    @InjectView(R.id.btn_edittext)
    Button btnEdittext;
    @InjectView(R.id.btn_Login)
    Button btn_Login;
    @InjectView(R.id.btn_leftMenu)
    Button btn_leftMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materdesign5);

        initView();

    }

    private void initView() {
        ButterKnife.inject(this);

        btnEdittext.setOnClickListener(this);
        btn_Login.setOnClickListener(this);
        btn_leftMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_edittext:
                startActivity(new Intent(this,EdittextActivity.class));
                break;
            case R.id.btn_Login:
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.btn_leftMenu:
                startActivity(new Intent(this,NavigationActivity.class));
                break;
        }
    }
}
