package com.example.administrator.allpoint.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/1.
 * AllPoint
 * 说明：Toast工具类
 */
public class Tu {
//    public static  final String

    public static void show(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

}
