package com.example.administrator.allpoint.mater_design.m_act_anim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.administrator.allpoint.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/12.
 * AllPoint
 * 说明：
 */
public class ActAnimActivity1 extends AppCompatActivity {

    @InjectView(R.id.iv_photo)
    ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_anim1);
        ButterKnife.inject(this);
    }
}
