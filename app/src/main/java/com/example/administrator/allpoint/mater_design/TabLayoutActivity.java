package com.example.administrator.allpoint.mater_design;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.allpoint.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/11.
 * AllPoint
 * 说明：实现tablayout滑动标签页
 */
public class TabLayoutActivity extends AppCompatActivity {

    @InjectView(R.id.tl_tab)
    TabLayout tlTab;
    @InjectView(R.id.vp_content)
    ViewPager vpContent;

    private TabPageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        initView();

    }

    private void initView() {
        ButterKnife.inject(this);

        adapter=new TabPageAdapter(getSupportFragmentManager(),this);
        vpContent.setAdapter(adapter);
        tlTab.setupWithViewPager(vpContent);
        //这里有两种模式MODE_FIXED和MODE_SCROLLABLE
        //MODE_FIXED为平分整个空间
        tlTab.setTabMode(TabLayout.MODE_SCROLLABLE);

        tlTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpContent.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


}
