package com.example.administrator.allpoint.mater_design.m_act_anim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.allpoint.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/12.
 * AllPoint
 * 说明：实现activity、迁移动画（第一个界面）
 * <p/>
 * 我们使用几种不同的方式来实现页面迁移动画
 */
public class ActAnimActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.iv_photo)
    ImageView ivPhoto;
    @InjectView(R.id.btn_default)
    Button btnDefault;
    @InjectView(R.id.btn_ActivityOptionsCompat01)
    Button btnActivityOptionsCompat01;
    @InjectView(R.id.btn_ActivityOptionsCompat02)
    Button btnActivityOptionsCompat02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_act_anim);

        initView();

    }

    private void initView() {
        ButterKnife.inject(this);


        btnDefault.setOnClickListener(this);
        btnActivityOptionsCompat01.setOnClickListener(this);
        btnActivityOptionsCompat02.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_default:
                Intent intent1 = new Intent(this, ActAnimActivity1.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
                break;
            case R.id.btn_ActivityOptionsCompat01:
                scaleUpAnimation(ivPhoto);
                break;

            case R.id.btn_ActivityOptionsCompat02:

                break;
        }
    }

    private void scaleUpAnimation(ImageView view) {
        //让新的Activity从一个小的范围扩大到全屏
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeScaleUpAnimation(view, //The View that the new activity is animating from
                        (int) view.getWidth() / 2, (int) view.getHeight() / 2, //拉伸开始的坐标
                        0, 0);//拉伸开始的区域大小，这里用（0，0）表示从无到全屏
        Intent intent = new Intent(this, ActAnimActivity1.class);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
