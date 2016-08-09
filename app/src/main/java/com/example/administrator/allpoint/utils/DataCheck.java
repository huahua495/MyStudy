package com.example.administrator.allpoint.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据检查
 * Sloop 创建于 2015/10/21.
 * <ul type="disc">
 * <li><a href="http://www.sloop.icoc.cc"    target="_blank">作者网站</a>      </li>
 * <li><a href="http://weibo.com/5459430586" target="_blank">作者微博</a>      </li>
 * <li><a href="https://github.com/GcsSloop" target="_blank">作者GitHub</a>   </li>
 * </ul>
 */
public class DataCheck {

    /**
     * 验证密码是否符合规则（6到16位的数字或者字母）
     *
     * @param password 需要校验的密码
     * @return true(正确)        false(不正确)
     */
    public static boolean checkPassword(String password) {
        String regex = "[\\w]{6,16}";
        return password.matches(regex);
    }

    /**
     * 验证邮箱是否正确
     *
     * @param email 邮箱地址
     * @return true(正确)        false(不正确)
     */
    public static boolean checkMail(String email) {
        //数字或者字母或者_出现3到12次 @ 数字或者字母出现一次或多次 (.字母出现一次或多次)出现1次到5次
        String reg = "[\\w]{3,20}@[\\w&&[^_]]+(\\.[a-zA-Z]+){1,5}";
        return email.matches(reg);
    }

    /**
     * 验证用户名的格式
     *
     * @param str 用户名
     * @return true（格式正确） false (不正确)
     */
    public static boolean checkAccount(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }

        String exp = "^[a-zA-Z][0-9a-zA-Z]{6,20}$";
        Pattern p = Pattern.compile(exp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 验证手机号码
     * @param str
     * @return
     */
    public static boolean isMoblie(String str){
        if(TextUtils.isEmpty(str)){
            return false;
        }
        String exp = "^1[34578][0-9]{9}$";
        if(str.matches(exp)){
            return true;
        }
        return false;
    }

    /**
     * 验证电话号码
     * @param str
     * @return
     */
    public static boolean isTelephone(String str){
        if(TextUtils.isEmpty(str)){
            return false;
        }
        String exp = "^(0[1-9]{2,3}-)?[1-9]\\d{6,7}$";
        if(str.matches(exp)){
            return true;
        }
        return false;
    }

    /**
     * 过滤特殊字符
     * @param content
     * @return
     */
    public static String filterSpecialChars(String content){
        return content.replace("-", "").replace(" ", "");
    }

}
