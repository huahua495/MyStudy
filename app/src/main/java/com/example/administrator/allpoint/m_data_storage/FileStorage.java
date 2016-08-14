package com.example.administrator.allpoint.m_data_storage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.allpoint.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by huahua on 2016/8/11.
 * 文件存储
 */
public class FileStorage extends AppCompatActivity {
    @InjectView(R.id.et_input)
    EditText etInput;
    @InjectView(R.id.btn_save)
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);
        initView();
        initData();
    }

    /**
     * 读取存储的数据
     */
    private void initData() {
        FileInputStream fis = null;
        BufferedReader buf = null;
        StringBuilder content = new StringBuilder();
        try {
            fis = openFileInput("data");
            buf = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while ((line = buf.readLine()) != null) {
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(content)) {
            etInput.setText("当前无存储数据!");
        } else {
            etInput.setText(content);
        }
    }

    private void initView() {
        ButterKnife.inject(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etInput.getText().toString();
                if (!TextUtils.isEmpty(text)) {
                    FileOutputStream out = null;
                    BufferedWriter br = null;
                    //第一个参数为文件名称 ，第二个参数为生命的全向
                    try {
                        out = openFileOutput("data", MODE_PRIVATE);
                        br = new BufferedWriter(new OutputStreamWriter(out));
                        br.write(text);

                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (br != null) {
                            try {
                                br.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        });
    }
}
