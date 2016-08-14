package com.example.administrator.allpoint.m_scroll;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.allpoint.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by huahua on 2016/8/14.
 */
public class ViewScroll extends AppCompatActivity {
    @InjectView(R.id.v_test)
    View vTest;
    @InjectView(R.id.btn_style1)
    Button btnStyle1;
    @InjectView(R.id.btn_style2)
    Button btnStyle2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scroll);
        initView();

    }
    private void initView() {
        ButterKnife.inject(this);
    }
    @OnClick({R.id.btn_style1,R.id.btn_style2})
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.btn_style1:
                vTest.scrollBy(100,100);
                break;
            case R.id.btn_style2:
                ObjectAnimator.ofFloat(vTest,"translationX",0,100).setDuration(1000).start();
                break;
        }
    }


}
