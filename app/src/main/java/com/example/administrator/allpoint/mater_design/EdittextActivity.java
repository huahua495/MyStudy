package com.example.administrator.allpoint.mater_design;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.allpoint.R;
import com.example.administrator.allpoint.utils.DataCheck;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/8/1.
 * AllPoint
 * 说明：5.0风格的输入框
 * <p/>
 * TextInputLayout不能单独使用，必须包裹EditView组件，且只能一个,设置错误提示信息时一定要先setErrorEnabled(true);再设置setError()。
 */
public class EdittextActivity extends AppCompatActivity implements View.OnClickListener{


    @InjectView(R.id.et_username)
    EditText etUsername;
    @InjectView(R.id.et_editlayout_5)
    TextInputLayout etEditlayout5;
    @InjectView(R.id.tv_submit)
    Button tvSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext_5);
        initView();

    }

    private void initView() {
        ButterKnife.inject(this);

        /**如果需要使hint提示内容浮动起来，需要手动设置hint内容*/

        etEditlayout5.setHint("请输入账号");
        etEditlayout5.setErrorEnabled(true);

        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.tv_submit:
                    checkAccount();
                break;
        }
    }

    /**
     * 检测账号
     * 需要使用特殊的方式获取到内容
     *
     * 在这里的话，这个setError()不能重复设置（貌似有点坑啊）
     */
    private void checkAccount() {
        String account=etEditlayout5.getEditText().getText().toString();

        if (TextUtils.isEmpty(account)){
            etEditlayout5.setError("请输入手机号码");
            return;
        }
        if (DataCheck.isMoblie(account)){
            etEditlayout5.setError("手机号码格式不正确");
            return;
        }


    }
}
