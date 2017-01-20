package com.zhangym.verificationcodeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhangym.customview.VerificationCodeView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private VerificationCodeView mCodeView;
    private Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCodeView = (VerificationCodeView) findViewById(R.id.verificationCodeView);
        mCodeView.setInterferenceCirclesRadius(8f);
        mCodeView.setInterferenceLinesCount(10);
        mCodeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(mRandom.nextInt(10)));
                sb.append(String.valueOf(mRandom.nextInt(10)));
                sb.append(String.valueOf(mRandom.nextInt(10)));
                sb.append(String.valueOf(mRandom.nextInt(10)));
                String s = sb.toString();

                mCodeView.setVerificationText(s);
            }
        });
    }
}
