package com.zhangym.verificationcodeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhangym.customview.VerificationCodeView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private VerificationCodeView mCodeView;
    private Random mRandom = new Random();
    private EditText etUsername;
    private EditText etPassword;
    private EditText etVerification;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initViews();

        login();

        mCodeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(mRandom.nextInt(10)) +
                        String.valueOf(mRandom.nextInt(10)) +
                        String.valueOf(mRandom.nextInt(10)) +
                        String.valueOf(mRandom.nextInt(10));

                mCodeView.setVerificationText(s);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String userName = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String verification = etVerification.getText().toString().trim();

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || TextUtils.isEmpty(verification)) {
            Toast.makeText(this, "请输入完整信息！", Toast.LENGTH_SHORT).show();
        } else {
            if ("zhangym".equals(userName) && "123".equals(password) && mCodeView.getVerificationText().equals
                    (verification)) {
                Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
            } else if (!"zhangym".equals(userName)) {
                Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();
            } else if (!"123".equals(password)) {
                Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
            } else if (!mCodeView.getVerificationText().equals(verification)) {
                Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void initViews() {
        mCodeView = (VerificationCodeView) findViewById(R.id.verificationCodeView);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        etVerification = (EditText) findViewById(R.id.et_verification);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}
