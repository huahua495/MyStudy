package com.example.administrator.allpoint.m_act;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.example.administrator.allpoint.R;
import com.example.administrator.allpoint.utils.Tu;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/9.
 * AllPoint
 * 说明：动画类
 */
public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.btn_alpha)
    Button btnAlpha;
    @InjectView(R.id.btn_rotate)
    Button btnRotate;
    @InjectView(R.id.btn_rotate_self)
    Button btnRotateSelf;
    @InjectView(R.id.btn_translate)
    Button btnTranslate;
    @InjectView(R.id.btn_scale)
    Button btnScale;
    @InjectView(R.id.btn_scale_self)
    Button btnScaleSelf;
    @InjectView(R.id.btn_animationset)
    Button btnAnimationset;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initView() {
        ButterKnife.inject(this);

        btnAlpha.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnRotateSelf.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnScaleSelf.setOnClickListener(this);
        btnAnimationset.setOnClickListener(this);


//        otherAnimation();
    }

    /**
     * 属性动画
     */
    private void otherAnimation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnAlpha, "alpha", 0.5f);
//        objectAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        });
//
//        /**
//         * 过滤一下
//         */
//        objectAnimator.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//            }
//        });
//
        objectAnimator.start();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                AlphaAnimation aa = new AlphaAnimation(0, 1);
                aa.setDuration(1000);
                btnAlpha.startAnimation(aa);
                break;
            case R.id.btn_rotate:
                RotateAnimation bb = new RotateAnimation(0, 360, btnRotate.getX(), btnRotate.getY());
                bb.setDuration(1000);
                btnRotate.startAnimation(bb);
                break;
            case R.id.btn_rotate_self:
                Tu.show(this, "旋转自身，需要获取到view的中心点坐标");

                break;
            case R.id.btn_translate:
                TranslateAnimation dd = new TranslateAnimation(btnTranslate.getX(), btnTranslate.getX() + 200, btnTranslate.getY(), btnTranslate.getY() + 200);
                dd.setDuration(1000);
                btnTranslate.startAnimation(dd);
                break;
            case R.id.btn_scale:
                ScaleAnimation ee = new ScaleAnimation(0, 2, 0, 2);
                ee.setDuration(1000);
                btnScale.startAnimation(ee);
                break;
            case R.id.btn_scale_self:
                Tu.show(this, "缩放自身，需要获取到view的中心点坐标");
                break;
            case R.id.btn_animationset:
                AnimationSet set = new AnimationSet(true);
                set.setDuration(1000);


                AlphaAnimation a1 = new AlphaAnimation(0, 1);
                a1.setDuration(1000);
                set.addAnimation(a1);

                TranslateAnimation ta = new TranslateAnimation(btnAnimationset.getLeft(), btnAnimationset.getLeft() + 200,
                        btnAnimationset.getTop(), btnAnimationset.getTop() + 200);

                ta.setDuration(1000);
                set.addAnimation(ta);

                btnAnimationset.startAnimation(set);
                break;
        }
    }


}
