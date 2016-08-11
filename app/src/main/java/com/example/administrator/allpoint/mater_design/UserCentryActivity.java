package com.example.administrator.allpoint.mater_design;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.allpoint.R;
import com.example.administrator.allpoint.customview.CircleImageView;
import com.example.administrator.allpoint.customview.MyListView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/11.
 * AllPoint
 * 说明：个人中心，带图片伸缩
 */
public class UserCentryActivity extends AppCompatActivity {

    @InjectView(R.id.backdrop)
    ImageView backdrop;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.lv_content)
    MyListView lvContent;
    @InjectView(R.id.ct_toolbar_layout)
    CollapsingToolbarLayout ct_toolbar_layout;

    private ArrayList<User> userList;
    private MyAdpter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_centry);

        initView();
        initData();
    }


    private void initView() {
        ButterKnife.inject(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ct_toolbar_layout.setTitle("个人中心");
    }

    private void initData() {
        userList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            User u = new User();
            u.setImgUrl(R.drawable.icon_user_avator);
            u.setName("萧" + i + "狼");
            u.setContent("这里有个一个南方的姑娘！");
            userList.add(u);
        }
        adapter = new MyAdpter(userList);
        lvContent.setAdapter(adapter);
    }


    class MyAdpter extends BaseAdapter {
        ArrayList<User> mList;

        public MyAdpter(ArrayList<User> mList) {
            this.mList = mList;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int i) {
            return mList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (view == null) {
                view = LayoutInflater.from(UserCentryActivity.this).inflate(R.layout.item_list_content, null);
                holder = new ViewHolder(view);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            holder.ivUserAvator.setImageResource(mList.get(i).getImgUrl());
            holder.tvUserName.setText(mList.get(i).getName());
            holder.tvIndruce.setText(mList.get(i).getContent());
            return view;
        }


        class ViewHolder {
            @InjectView(R.id.iv_user_avator)
            CircleImageView ivUserAvator;
            @InjectView(R.id.tv_user_name)
            TextView tvUserName;
            @InjectView(R.id.tv_indruce)
            TextView tvIndruce;

            ViewHolder(View view) {
                ButterKnife.inject(this, view);
            }
        }
    }


    class User {
        private int imgUrl;
        private String name;
        private String content;

        public int getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(int imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
