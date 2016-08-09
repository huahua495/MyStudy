package com.example.administrator.allpoint.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/7/29.
 * AllPoint
 * 说明：打印日志的类
 */
public class L {
    public static final String TAG = "AllPoint";


    public static void i(String msg) {
        Log.i(TAG, msg);
    }
    public static void e(String msg) {
        Log.e(TAG, msg);
    }
}
