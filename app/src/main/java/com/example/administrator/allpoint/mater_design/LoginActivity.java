package com.example.administrator.allpoint.mater_design;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.allpoint.R;
import com.example.administrator.allpoint.utils.DataCheck;
import com.example.administrator.allpoint.utils.Tu;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/1.
 * AllPoint
 * 说明：MaterDesign的登录界面（看起来样式是不错的）
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @InjectView(R.id.input_email)
    EditText inputEmail;
    @InjectView(R.id.input_password)
    EditText inputPassword;
    @InjectView(R.id.btn_login)
    AppCompatButton btnLogin;
    @InjectView(R.id.link_signup)
    TextView linkSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    private void initView() {
        ButterKnife.inject(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        /**首先进行验证*/
        if (!checkData()){
            Tu.show(this,"用户名和密码错误");
            return;
        }

        Tu.show(this,"登录ing!");

    }

    /***
     * 校检账号和密码
     * @return
     */
    private boolean checkData() {
        boolean valid = true;

        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            inputEmail.setError("手机号码不能为空");
            valid = false;

        }else if(!DataCheck.isMoblie(email)){
            inputEmail.setError("手机号码格式不正确");
            valid = false;
        }else{
            inputEmail.setError(null);
        }

        if (password.isEmpty()) {
            inputPassword.setError("请输入密码");
            valid = false;
        } else  if(!DataCheck.checkPassword(password)){
            inputPassword.setError("密码为6到16位的数字或者字母");
            valid = false;
        }else{
            inputPassword.setError(null);
        }

        return valid;
    }


//    @Override
//    public void onBackPressed() {
////        super.onBackPressed();
//        moveTaskToBack(true);
//
//    }
}
