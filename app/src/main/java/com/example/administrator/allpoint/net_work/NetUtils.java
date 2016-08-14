package com.example.administrator.allpoint.net_work;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by huahua on 2016/8/13.
 */
public class NetUtils {

    /**
     * get请求方式
     *
     * @param url
     */
    public static String get(String url) {
        StringBuilder sb = null;
        try {
            URL path = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) path.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10000);//设置链接超时时间

            //获取到数据输入流
            InputStream is = conn.getInputStream();
//            使用bufferedReader读取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            sb = new StringBuilder();
            String read = "";
            if ((read = br.readLine()) != null) {
                sb.append(read);
            }
        } catch (MalformedURLException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * post方式请求
     * @param str
     * @return
     *
     * 在获取输入流之前，先将需要传递的数据写出
     */
    public static String post(String str){
        try {
            URL url=new URL(str);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(10000);
            conn.setDoOutput(true);
            conn.setDoOutput(true);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
