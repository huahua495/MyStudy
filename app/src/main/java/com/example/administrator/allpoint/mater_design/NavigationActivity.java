package com.example.administrator.allpoint.mater_design;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.administrator.allpoint.R;
import com.example.administrator.allpoint.utils.Tu;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/1.
 * AllPoint
 * 说明：NavigationView  侧边栏
 */
public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @InjectView(R.id.navigation)
    NavigationView navigation;
    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        initView();
    }

    private void initView() {
        ButterKnife.inject(this);
        navigation.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // int id = menuItem.getItemId();
        //同时可以根据不同的id处理不同的事件


        String title = (String) item.getTitle();
        Tu.show(this, "您点击了 " + title);

        return super.onContextItemSelected(item);

    }
}
