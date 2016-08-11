package com.example.administrator.allpoint.mater_design;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/8/11.
 * AllPoint
 * 说明：
 */
public class TabPageAdapter extends FragmentPagerAdapter{
    final int PAGE_COUNT = 9;
    private String tabTitles[] = new String[]{"全部", "爱心", "分享", "专注", "诚实", "自信", "合作", "创造", "责任"};
    private Context context;

    public TabPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
