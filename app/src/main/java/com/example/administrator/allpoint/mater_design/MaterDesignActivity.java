package com.example.administrator.allpoint.mater_design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.allpoint.R;
import com.example.administrator.allpoint.mater_design.m_act_anim.ActAnimActivity;

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
    @InjectView(R.id.btn_toolbar)
    Button btn_toolbar;
    @InjectView(R.id.btn_tabLayout)
    Button btn_tabLayout;
    @InjectView(R.id.btn_AppBarLayout)
    Button btn_AppBarLayout;
    @InjectView(R.id.btn_AppBarLayout1)
    Button btn_AppBarLayout1;
    @InjectView(R.id.btn_ActivityOptionsCompat)
    Button btn_ActivityOptionsCompat;

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
        btn_toolbar.setOnClickListener(this);
        btn_tabLayout.setOnClickListener(this);
        btn_AppBarLayout.setOnClickListener(this);
        btn_AppBarLayout1.setOnClickListener(this);
        btn_ActivityOptionsCompat.setOnClickListener(this);
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
            case R.id.btn_toolbar:
                startActivity(new Intent(this,ToolBarActivity.class));
                break;
            case R.id.btn_tabLayout:
                startActivity(new Intent(this,TabLayoutActivity.class));
                break;
            case R.id.btn_AppBarLayout:
                startActivity(new Intent(this,AppBarActivity.class));
                break;
            case R.id.btn_AppBarLayout1:
                startActivity(new Intent(this,UserCentryActivity.class));
                break;
            case R.id.btn_ActivityOptionsCompat:
                startActivity(new Intent(this, ActAnimActivity.class));
                break;
        }
    }
}
