package com.example.administrator.allpoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.administrator.allpoint.m_act.AnimationActivity;
import com.example.administrator.allpoint.mater_design.MaterDesignActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.btn_mater_design)
    Button btnMaterDesign;
    @InjectView(R.id.fab)
    FloatingActionButton fab;



    @InjectView(R.id.btn_view_animation)
    Button btn_view_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(this);
        btnMaterDesign.setOnClickListener(this);
        btn_view_animation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.btn_mater_design:
                startActivity(new Intent(this, MaterDesignActivity.class));
                break;
            case R.id.btn_view_animation:
                startActivity(new Intent(this, AnimationActivity.class));
                break;
        }
    }
}
